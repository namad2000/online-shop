package ir.shop.online.core.presentation.rest;

import ir.shop.online.Infrastructure.mapper.AddressMapper;
import ir.shop.online.application.dto.req.CreateAddressRequest;
import ir.shop.online.core.domain.usecase.AddressUseCase;
import ir.shop.online.core.presentation.rest.dto.AddressDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressUseCase addressService;
    private final AddressMapper addressMapper;

    @PostMapping("/{userId}/add")
    public AddressDTO addAddress(@PathVariable("userId") Long userId,
                                 @RequestBody CreateAddressRequest request) {
        return addressMapper.toDTO(addressService.add(userId, request));
    }

    @GetMapping("/{userId}/list")
    public ResponseEntity<?> getAllAddresses(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(addressService.getAllByUserId(userId).stream().map(addressMapper::toDTO).toList());
    }

    @PatchMapping("/{userId}/{addressId}")
    public ResponseEntity<?> changeMainAddress(@PathVariable("userId") Long userId,
                                               @PathVariable("addressId") Long addressId) {
        return ResponseEntity.ok(addressMapper.toDTO(addressService.setDefaultAddress(userId, addressId)));
    }

    @DeleteMapping("/{userId}/{addressId}")
    public ResponseEntity<?> deleteAddress(@PathVariable("userId") Long userId,
                                           @PathVariable("addressId") Long addressId) {
        addressService.deleteAddress(userId, addressId);
        return ResponseEntity.ok().build();
    }
}
