package ir.online.shop.domain.repository.jpa;


import io.qoop.domain.repository.DomainRepository;
import ir.online.shop.domain.model.Media;
import ir.online.shop.domain.model.enums.MediaOwnerType;
import ir.online.shop.domain.model.enums.MediaType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface MediaRepository extends DomainRepository<Media, UUID> {
    Optional<Media> findByUrl(String url);

    Boolean existsByUrl(String url);

    Boolean existsByHash(String hash);

    Optional<String> findUrlByHash(String hash);

    List<Media> findByOwnerIdAndMediaOwnerType(UUID ownerId, MediaOwnerType mediaOwnerType);

    Optional<Media> findByIdAndMediaTypeAndMediaOwnerType(UUID id, MediaType mediaType, MediaOwnerType mediaOwnerType);

    List<Media> findAllById(List<UUID> mediaIds);

    List<Media> saveAll(List<Media> media);

    void deleteAll(List<Media> media);

    Optional<Media> findByHash(String hash);
}
