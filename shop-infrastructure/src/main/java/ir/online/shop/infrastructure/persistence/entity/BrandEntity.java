package ir.online.shop.infrastructure.persistence.entity;

import io.qoop.jpa.persistence.entity.ActiveDeleteAuditingEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "brands")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BrandEntity extends ActiveDeleteAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String country;

    private String slug;

    @Builder.Default
    @OneToMany(targetEntity = MediaEntity.class, mappedBy = "ownerId", fetch = FetchType.LAZY)
    private Set<MediaEntity> medias = new HashSet<>();
}
