package ir.shop.online.core.application.adapter;


import ir.shop.online.commons.domain.annotation.UseCaseService;
import ir.shop.online.commons.domain.exception.DomainException;
import ir.shop.online.commons.domain.validation.IsValid;
import ir.shop.online.commons.domain.validation.Max;
import ir.shop.online.core.domain.exception.ExceptionCode;
import ir.shop.online.core.domain.model.address.Address;
import ir.shop.online.core.domain.model.address.CreateAddress;
import ir.shop.online.core.domain.model.user.User;
import ir.shop.online.core.domain.repository.jpa.AddressRepository;
import ir.shop.online.core.domain.usecase.AddressUseCase;
import ir.shop.online.core.domain.usecase.UserUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCaseService
@RequiredArgsConstructor
public class AddressUseCaseAdapter implements AddressUseCase {

    private final AddressRepository addressRepository;
    private final UserUseCase userUseCase;

    @IsValid
    @Override
    public Address add(@Max(100) Long userId, @IsValid CreateAddress createAddress) {

        User user = userUseCase.getById(userId);

        // بررسی تکراری بودن عنوان آدرس
        if (addressRepository.findByUserAndTitle(user, createAddress.getTitle()) != null) {
            throw new DomainException(ExceptionCode.ADDRESS_01.name());
        }

        // حالت 1: اگر کاربر هیچ آدرس ندارد → این آدرس خودکار پیش‌فرض می‌شود
        if (user.getAddresses().isEmpty()) {
            createAddress.setIsDefault(true);
        }

        // حالت 2: اگر آدرس جدید پیش‌فرض است → تمام آدرس‌های قبلی را false کن
        if (Boolean.TRUE.equals(createAddress.getIsDefault())) {
            user.getAddresses().forEach(addr -> addr.setIsDefault(false));
        }

        // ساخت و ذخیره آدرس جدید
        Address newAddress = Address.builder()
                .title(createAddress.getTitle())
                .address(createAddress.getAddress())
                .postalCode(createAddress.getPostalCode())
                .isDefault(Boolean.TRUE.equals(createAddress.getIsDefault()))
                .user(user)
                .build();

        return addressRepository.save(newAddress);
    }

    @Override
    public List<Address> getAllByUserId(Long userId) {
        User user = userUseCase.getById(userId);
        return addressRepository.findByUserId(user.getId());
    }

    @Override
    public Address setDefaultAddress(Long userId, Long addressId) {

        // دریافت کاربر
        User user = userUseCase.getById(userId);

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
        User user = userUseCase.getById(userId);

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
