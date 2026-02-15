package ir.online.shop.domain.model;


import io.qoop.domain.model.UpdateModel;
import ir.online.shop.domain.model.enums.MediaOwnerType;
import ir.online.shop.domain.model.enums.MediaType;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Vendor extends UpdateModel<UUID> {

    private Customer customer;

    private String commercialName;

    private Set<Media> avatar;

    @Builder.Default
    private Set<Address> addresses = new HashSet<>();

    public Media getAvatar() {
        return avatar.stream().filter(x -> x.isMain()
                        && x.getMediaType() == MediaType.IMAGE
                        && x.getMediaOwnerType() == MediaOwnerType.AVATAR).findFirst()
                .orElse(null);
    }
}
