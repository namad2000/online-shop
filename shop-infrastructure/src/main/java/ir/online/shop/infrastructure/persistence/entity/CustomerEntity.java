package ir.online.shop.infrastructure.persistence.entity;

import io.qoop.jpa.persistence.entity.ActiveDeleteAuditingEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CustomerEntity extends ActiveDeleteAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Builder.Default
    @OneToMany(targetEntity = MediaEntity.class, mappedBy = "ownerId", fetch = FetchType.LAZY)
    private Set<MediaEntity> medias = new HashSet<>();
}
