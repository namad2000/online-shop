package ir.shop.online.application.service.impl;

import ir.shop.online.Infrastructure.repository.AddressRepository;
import ir.shop.online.application.dto.req.CreateAddressRequest;
import ir.shop.online.application.service.AddressService;
import ir.shop.online.application.service.UserService;
import ir.shop.online.domain.exception.DomainException;
import ir.shop.online.domain.exception.ExceptionCode;
import ir.shop.online.domain.model.entity.Address;
import ir.shop.online.domain.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final UserService userService;

    @Override
    public Address add(Long userId, CreateAddressRequest request) {

        User user = userService.getById(userId);

        // بررسی تکراری بودن عنوان آدرس
        if (addressRepository.findByUserAndTitle(user, request.getTitle()) != null) {
            throw new DomainException(ExceptionCode.ADDRESS_01);
        }

        // حالت 1: اگر کاربر هیچ آدرس ندارد → این آدرس خودکار پیش‌فرض می‌شود
        if (user.getAddresses().isEmpty()) {
            request.setIsDefault(true);
        }

        // حالت 2: اگر آدرس جدید پیش‌فرض است → تمام آدرس‌های قبلی را false کن
        if (Boolean.TRUE.equals(request.getIsDefault())) {
            user.getAddresses().forEach(addr -> addr.setIsDefault(false));
        }

        // ساخت و ذخیره آدرس جدید
        Address newAddress = Address.builder()
                .title(request.getTitle())
                .address(request.getAddress())
                .postalCode(request.getPostalCode())
                .isDefault(Boolean.TRUE.equals(request.getIsDefault()))
                .user(user)
                .build();

        return addressRepository.save(newAddress);
    }

    @Override
    public List<Address> getAllByUserId(Long userId) {
        User user = userService.getById(userId);
        return addressRepository.findByUserId(user.getId());
    }

    @Override
    public Address setDefaultAddress(Long userId, Long addressId) {

        // دریافت کاربر
        User user = userService.getById(userId);

        // پیدا کردن آدرس موردنظر
        Address addressToSet = addressRepository.findById(addressId)
                .orElseThrow(() -> new DomainException(ExceptionCode.ADDRESS_02));

        // بررسی تعلق آدرس به کاربر
        if (!addressToSet.getUser().getId().equals(userId)) {
            throw new DomainException(ExceptionCode.ADDRESS_03);
        }

        // اگر آدرس قبلاً دیفالت بوده، کاری لازم نیست
        if (Boolean.TRUE.equals(addressToSet.getIsDefault())) {
            return addressToSet;
        }

        // تمام آدرس‌های قبلی را false کن
        user.getAddresses().forEach(addr -> addr.setIsDefault(false));

        // آدرس موردنظر را true کن
        addressToSet.setIsDefault(true);

        // ذخیره تغییرات
        addressRepository.saveAll(user.getAddresses()); // تغییرات سایر آدرس‌ها
        return addressRepository.save(addressToSet);   // تغییرات آدرس جدید
    }

    @Override
    public void deleteAddress(Long userId, Long addressId) {
        // دریافت کاربر
        User user = userService.getById(userId);

        // پیدا کردن آدرس موردنظر
        Address addressToDelete = addressRepository.findById(addressId)
                .orElseThrow(() -> new DomainException(ExceptionCode.ADDRESS_02));

        // بررسی تعلق آدرس به کاربر
        if (!addressToDelete.getUser().getId().equals(userId)) {
            throw new DomainException(ExceptionCode.ADDRESS_03);
        }

        addressRepository.delete(addressToDelete);
    }
}
