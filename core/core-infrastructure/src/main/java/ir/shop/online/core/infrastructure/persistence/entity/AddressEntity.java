package ir.shop.online.core.infrastructure.persistence.entity;

import ir.shop.online.commons.infrastructure.entity.AuditEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class AddressEntity extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;

    @NotBlank(message = "عنوان آدرس نمی‌تواند خالی باشد")
    @Column(name = "title", nullable = false)
    private String title;

    @NotBlank(message = "آدرس نمی‌تواند خالی باشد")
    @Column(columnDefinition = "TEXT", nullable = false)
    private String address;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "is_default")
    private Boolean isDefault = false;
}
