package ir.shop.online.domain.model.entity;


import ir.shop.online.commons.entity.AuditEntity;
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
