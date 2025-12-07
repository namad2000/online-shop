package ir.shop.online.core.infrastructure.persistence.entity;

import ir.shop.online.commons.infrastructure.entity.AuditEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ProductEntity extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "نام محصول نمی‌تواند خالی باشد")
    @Size(min = 2, max = 150, message = "نام محصول باید بین ۲ تا ۱۵۰ کاراکتر باشد")
    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @NotNull(message = "قیمت محصول الزامی است")
    @Column(nullable = false)
    private BigDecimal price;

    @Column(name = "stock_quantity")
    private Integer stockQuantity;

    @Column(name = "sku", unique = true)
    private String sku; // شناسه محصول

    // ارتباط با دسته‌بندی
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryEntity;

    // ویژگی‌ها و تصاویر محصول (اختیاری)
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private Set<ProductImageEntity> images = new HashSet<>();

}
