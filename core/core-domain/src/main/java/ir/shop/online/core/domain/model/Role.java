package ir.shop.online.core.domain.model;


import ir.shop.online.commons.infrastructure.entity.AuditEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Role extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @NotBlank(message = "نام نمی‌تواند خالی باشد")
    @Size(min = 2, max = 100, message = "نام باید بین ۲ تا ۱۰۰ کاراکتر باشد")
    @Column(nullable = false)
    private String name;

    @Column(name = "description")
    private String description;


}
