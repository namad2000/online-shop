package ir.online.shop.infrastructure.persistence.repository.jpa;


import io.qoop.domain.model.PageData;
import ir.online.shop.domain.model.Media;
import ir.online.shop.domain.model.enums.MediaOwnerType;
import ir.online.shop.domain.model.enums.MediaType;
import ir.online.shop.domain.repository.jpa.MediaRepository;
import ir.online.shop.infrastructure.persistence.entity.MediaEntity;
import ir.online.shop.infrastructure.persistence.mapper.MediaMapper;
import ir.online.shop.infrastructure.persistence.repository.jpa.spring.MediaJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class MediaRepositoryAdapter implements MediaRepository {

    private final MediaJpaRepository mediaJpaRepository;
    private final MediaMapper mediaMapper;

    @Override
    public Media save(Media media) {
        MediaEntity mediaEntity = mediaMapper.toEntity(media);
        mediaEntity = mediaJpaRepository.save(mediaEntity);

        return mediaMapper.toDomain(mediaEntity);
    }

    @Override
    public Optional<Media> findById(UUID id) {
        return mediaJpaRepository.findById(id)
                .map(mediaMapper::toDomain);
    }

    @Override
    public Boolean existById(UUID id) {
        return mediaJpaRepository.existsById(id);
    }

    @Override
    public PageData<Media> findAll(Integer pageNumber, Integer pageSize) {
        return null;
    }

    @Override
    public void delete(Media domain, boolean logical) {

    }

    @Override
    public Optional<Media> findByUrl(String url) {
        return mediaJpaRepository.findByUrl(url)
                .map(mediaMapper::toDomain);
    }

    @Override
    public Boolean existsByUrl(String url) {
        return mediaJpaRepository.existsByUrl(url);
    }

    @Override
    public Boolean existsByHash(String hash) {
        return mediaJpaRepository.existsByHash(hash);
    }

    @Override
    public Optional<String> findUrlByHash(String hash) {
        return mediaJpaRepository.findUrlByHash(hash);
    }

    @Override
    public List<Media> findByOwnerIdAndMediaOwnerType(UUID ownerId, MediaOwnerType mediaOwnerType) {
        return mediaJpaRepository.findByOwnerIdAndMediaOwnerType(ownerId, mediaOwnerType)
                .stream().map(mediaMapper::toDomain).toList();
    }

    @Override
    public Optional<Media> findByIdAndMediaTypeAndMediaOwnerType(UUID id, MediaType mediaType, MediaOwnerType mediaOwnerType) {
        return mediaJpaRepository.findByIdAndMediaTypeAndMediaOwnerType(id, mediaType, mediaOwnerType)
                .map(mediaMapper::toDomain);
    }

    @Override
    public List<Media> findAllById(List<UUID> mediaIds) {
        return mediaJpaRepository.findAllById(mediaIds).stream().map(mediaMapper::toDomain).toList();
    }

    @Override
    public List<Media> saveAll(List<Media> medias) {
        return mediaJpaRepository.saveAll(medias.stream().map(mediaMapper::toEntity).toList())
                .stream().map(mediaMapper::toDomain).toList();
    }

    @Override
    public void deleteAll(List<Media> medias) {
        //todo implements delete all logical or physical
    }

    @Override
    public Optional<Media> findByHash(String hash) {
        return mediaJpaRepository.findByHash(hash)
                .map(mediaMapper::toDomain);
    }

}
