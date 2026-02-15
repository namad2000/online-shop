package ir.online.shop.domain.service;

import io.qoop.fault.handler.api.exception.DomainException;
import io.qoop.filter.bean.api.DomainService;
import io.qoop.utils.api.hash.HashUtil;
import ir.online.shop.domain.exception.MediaExceptionCode;
import ir.online.shop.domain.model.Media;
import ir.online.shop.domain.model.enums.MediaOwnerType;
import ir.online.shop.domain.model.enums.MediaStatus;
import ir.online.shop.domain.model.enums.MediaType;
import ir.online.shop.domain.model.media.UploadMedia;
import ir.online.shop.domain.repository.jpa.MediaRepository;
import lombok.RequiredArgsConstructor;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@DomainService
@RequiredArgsConstructor
public class MediaService {

    private final MediaRepository mediaRepository;
    private final CdnStorageService cdnStorageService; // Interface to your CDN

    public Media upload(UploadMedia command, MediaOwnerType ownerType, UUID ownerId, boolean generateThumbnail) {
        try {
            // 1️⃣ Calculate file hash for deduplication
            String hash = HashUtil.calculateHash(command.getBytes());

            // 2️⃣ Check if the file already exists
            Optional<Media> existing = mediaRepository.findByHash(hash);
            if (existing.isPresent()) {
                return existing.get(); // Return existing media if file is duplicate
            }

            // 3️⃣ Upload main file to CDN
            InputStream fileStream = command.getInputStream() != null
                    ? command.getInputStream()
                    : new ByteArrayInputStream(command.getBytes());
            String url = cdnStorageService.upload(fileStream.readAllBytes(), command.getOriginalFilename(), command.getContentType());

            // 4️⃣ Save main media entity
            Media mainMedia = Media.builder()
                    .hash(hash)
                    .url(url)
                    .size(command.getSize())
                    .mimeType(command.getContentType())
                    .mediaType(getMediaType(command.getContentType()))
                    .mediaOwnerType(ownerType)
                    .ownerId(ownerId)
                    .mediaStatus(MediaStatus.TEMP) // TEMP until attached
                    .thumbnail(false)
                    .build();
            mainMedia = mediaRepository.save(mainMedia);

            // 5️⃣ Optionally generate and save thumbnail
            if (generateThumbnail) {
                InputStream thumbStream = new ByteArrayInputStream(command.getBytes()); // Could resize here
                String thumbUrl = cdnStorageService.upload(thumbStream.readAllBytes(), "thumb_" + command.getOriginalFilename(), command.getContentType());

                Media thumbMedia = Media.builder()
                        .url(thumbUrl)
                        .size(command.getSize())
                        .mimeType(command.getContentType())
                        .mediaType(getMediaType(command.getContentType()))
                        .mediaOwnerType(ownerType)
                        .thumbnail(true)
                        .parent(mainMedia)
                        .mediaStatus(MediaStatus.TEMP)
                        .build();
                mediaRepository.save(thumbMedia);
            }

            return mainMedia;
        } catch (Exception e) {
            throw new RuntimeException("Failed to upload media file", e);
        }
    }

    public void assignAndUpdate(Media media, UUID ownerId, boolean isMain) {
        media.setMain(isMain);
        media.setOwnerId(ownerId);
        media.setMediaStatus(MediaStatus.ASSIGNED);
        mediaRepository.save(media);
    }

    public Media getMedia(UUID logoId, MediaType mediaType, MediaOwnerType mediaOwnerType) {
        return mediaRepository.findByIdAndMediaTypeAndMediaOwnerType(logoId, mediaType, mediaOwnerType)
                .orElseThrow(() -> DomainException.of(MediaExceptionCode.MEDIA_NOT_FOUND));
    }

    public List<Media> getMediasByOwnerId(UUID ownerId, MediaOwnerType mediaOwnerType) {
        return mediaRepository.findByOwnerIdAndMediaOwnerType(ownerId, mediaOwnerType);
    }

    private MediaType getMediaType(String contentType) {
        String[] split = contentType.split("/");
        if (split.length > 0) {
            if (split[0].equalsIgnoreCase("image")) {
                return MediaType.IMAGE;
            } else if (split[0].equalsIgnoreCase("pdf")) {
                return MediaType.PDF;
            }
        }
        throw DomainException.of(MediaExceptionCode.MEDIA_TYPE_NOT_SUPPORTED);
    }

    public Media getMediaByUrl(String url, MediaOwnerType mediaOwnerType) {
        return mediaRepository.findByUrl(url).filter(x -> x.getMediaOwnerType() == mediaOwnerType)
                .orElseThrow(() -> DomainException.of(MediaExceptionCode.MEDIA_NOT_FOUND));
    }
}
