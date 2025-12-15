package ir.shop.online.commons.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class ActiveAuditingEntity extends AuditingEntity {
    @Column(name = "is_active")
    private Boolean isActive;
}
