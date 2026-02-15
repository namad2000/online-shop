package ir.online.shop.infrastructure.persistence.entity;

import io.qoop.jpa.persistence.entity.ActiveDeleteAuditingEntity;
import ir.online.shop.domain.model.enums.MediaOwnerType;
import ir.online.shop.domain.model.enums.MediaStatus;
import ir.online.shop.domain.model.enums.MediaType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Entity
@Table(name = "medias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class MediaEntity extends ActiveDeleteAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String hash;

    private Long size;

    private String mimeType;

    private String url;

    @Enumerated(EnumType.STRING)
    private MediaType mediaType;

    @Enumerated(EnumType.STRING)
    private MediaStatus mediaStatus;

    private Boolean main;

    @Enumerated(EnumType.STRING)
    private MediaOwnerType mediaOwnerType;

    private UUID ownerId;

    private boolean thumbnail;

    @ManyToOne(fetch = FetchType.LAZY)
    private MediaEntity parent;
}
