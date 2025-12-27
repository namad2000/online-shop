package ir.shop.online.commons.domain.model;

import ir.shop.online.commons.domain.validation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Author: davood akbari
 * Email: daak1365@gmail.com
 * Created: 12/7/2025 4:59 PM
 * Package: ir.shop.online.commons.infrastructure.model
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Version<ID> {

    @NotNull
    protected ID id;

    @NotNull
    protected Integer version;
}
