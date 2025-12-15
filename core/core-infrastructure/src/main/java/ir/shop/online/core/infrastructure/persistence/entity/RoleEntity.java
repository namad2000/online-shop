//package ir.shop.online.core.infrastructure.persistence.entity;
//
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Size;
//import lombok.*;
//import lombok.experimental.SuperBuilder;
//
//@Entity
//@Table(name = "roles")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@SuperBuilder
//public class RoleEntity extends AuditEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", updatable = false, nullable = false)
//    private Integer id;
//
//    @NotBlank(message = "نام نمی‌تواند خالی باشد")
//    @Size(min = 2, max = 100, message = "نام باید بین ۲ تا ۱۰۰ کاراکتر باشد")
//    @Column(nullable = false)
//    private String name;
//
//    @Column(name = "description")
//    private String description;
//
//
//}
