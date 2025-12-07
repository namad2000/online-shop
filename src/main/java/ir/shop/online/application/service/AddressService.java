package ir.shop.online.application.service;

import ir.shop.online.application.dto.req.CreateAddressRequest;
import ir.shop.online.application.dto.req.CreateUserRequest;
import ir.shop.online.domain.model.entity.Address;
import ir.shop.online.domain.model.entity.User;

import java.util.List;

public interface AddressService {
    Address add(Long userId, CreateAddressRequest request);

    List<Address> getAllByUserId(Long userId);

    Address setDefaultAddress(Long userId, Long addressId);

    void deleteAddress(Long userId, Long addressId);
}
