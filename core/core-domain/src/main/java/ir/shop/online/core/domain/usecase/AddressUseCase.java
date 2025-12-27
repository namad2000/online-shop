package ir.shop.online.core.domain.usecase;

import ir.shop.online.core.domain.model.Address;
import ir.shop.online.core.domain.model.cmd.address.CreateAddress;

import java.util.List;

public interface AddressUseCase {
    Address add(Long userId, CreateAddress request);

    List<Address> getAllByUserId(Long userId);

    Address setDefaultAddress(Long userId, Long addressId);

    void deleteAddress(Long userId, Long addressId);
}
