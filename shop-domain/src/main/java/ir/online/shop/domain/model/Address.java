package ir.online.shop.domain.model;

import io.qoop.domain.model.UpdateModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Address extends UpdateModel<UUID> {

    private Customer user;

    private String title;

    private String address;

    private String postalCode;

    private Boolean isDefault = false;
}
