package ir.online.shop.infrastructure.persistence.repository.jpa.spring;


import ir.online.shop.domain.model.enums.MediaOwnerType;
import ir.online.shop.domain.model.enums.MediaType;
import ir.online.shop.infrastructure.persistence.entity.MediaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MediaJpaRepository extends JpaRepository<MediaEntity, UUID> {
    Optional<MediaEntity> findByUrl(String url);

    boolean existsByUrl(String url);

    @Query("select m.url from MediaEntity m where m.hash = :hash")
    Optional<String> findUrlByHash(@Param("hash") String hash);

    Optional<MediaEntity> findByHash(String hash);

    boolean existsByHash(String hash);

    List<MediaEntity> findByOwnerIdAndMediaOwnerType(UUID ownerId, MediaOwnerType mediaOwnerType);

    Optional<MediaEntity> findByIdAndMediaTypeAndMediaOwnerType(UUID id, MediaType mediaType, MediaOwnerType mediaOwnerType);
}
