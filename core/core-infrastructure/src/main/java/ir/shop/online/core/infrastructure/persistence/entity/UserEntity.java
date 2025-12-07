package ir.shop.online.core.infrastructure.persistence.entity;


import ir.shop.online.commons.infrastructure.entity.AuditEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UserEntity extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @NotBlank(message = "نام نمی‌تواند خالی باشد")
    @Size(min = 2, max = 100, message = "نام باید بین ۲ تا ۱۰۰ کاراکتر باشد")
    @Column(nullable = false)
    private String firstName;

    @NotBlank(message = "نام خانوادگی نمی‌تواند خالی باشد")
    @Size(min = 2, max = 100, message = "نام خانوادگی باید بین ۲ تا ۱۰۰ کاراکتر باشد")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Pattern(regexp = "^09[0-9]{9}$", message = "شماره موبایل معتبر نیست")
    @Column(name = "mobile_number", nullable = false, unique = true)
    private String mobileNumber;

    @Email(message = "ایمیل معتبر نیست")
    @Column(unique = true)
    private String email;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Builder.Default
    private Set<RoleEntity> roleEntities = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private Set<AddressEntity> addressEntities = new HashSet<>();
}
