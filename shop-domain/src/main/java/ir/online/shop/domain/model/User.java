package ir.online.shop.domain.model;


import io.qoop.domain.model.UpdateModel;
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
public class User extends UpdateModel<UUID> {

    private String firstName;

    private String lastName;

    private String mobileNumber;

    private String email;

    @Builder.Default
    private Set<Role> roles = new HashSet<>();

    @Builder.Default
    private Set<Address> addresses = new HashSet<>();
}
