package ir.shop.online.core.domain.model;


import ir.shop.online.commons.domain.model.Version;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class User extends Version<Long> {

    private String firstName;

    private String lastName;

    private String mobileNumber;

    private String email;

    @Builder.Default
    private Set<Role> roles = new HashSet<>();

    @Builder.Default
    private Set<Address> addresses = new HashSet<>();
}
