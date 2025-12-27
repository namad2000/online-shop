package ir.shop.online.core.domain.model;

import ir.shop.online.commons.domain.model.Version;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Address extends Version<Long> {

    private User user;

    private String title;

    private String address;

    private String postalCode;

    private Boolean isDefault = false;
}
