package ir.online.shop.application.port.in.usecase;//package ir.online.core.application.adapter;
//
//
//import ir.online.commons.filter.bean.UseCaseService;
//import ir.online.commons.domain.exception.DomainException;
//import ir.online.commons.domain.validation.IsValid;
//import ir.online.commons.domain.validation.Max;
//import ir.online.core.domain.exception.ExceptionCode;
//import ir.online.core.domain.model.address.Address;
//import ir.online.core.domain.model.address.CreateAddress;
//import ir.online.core.domain.model.customer.Customer;
//import ir.online.core.domain.repository.jpa.AddressRepository;
//import ir.online.core.domain.usecase.AddressUseCase;
//import ir.online.core.domain.usecase.UserUseCase;
//import lombok.RequiredArgsConstructor;
//
//import java.util.List;
//
//@UseCaseService
//@RequiredArgsConstructor
//public class AddressUseCaseAdapter implements AddressUseCase {
//
//    private final AddressRepository addressRepository;
//    private final UserUseCase userUseCase;
//
//    @IsValid
//    @Override
//    public Address add(@Max(100) Long userId, @IsValid CreateAddress createAddress) {
//
//        Customer customer = userUseCase.getById(userId);
//
//        // بررسی تکراری بودن عنوان آدرس
//        if (addressRepository.findByUserAndTitle(customer, createAddress.getTitle()) != null) {
//            throw DomainException.of(ExceptionCode.ADDRESS_01.name());
//        }
//
//        // حالت 1: اگر کاربر هیچ آدرس ندارد → این آدرس خودکار پیش‌فرض می‌شود
//        if (customer.getAddresses().isEmpty()) {
//            createAddress.setIsDefault(true);
//        }
//
//        // حالت 2: اگر آدرس جدید پیش‌فرض است → تمام آدرس‌های قبلی را false کن
//        if (Boolean.TRUE.equals(createAddress.getIsDefault())) {
//            customer.getAddresses().forEach(addr -> addr.setIsDefault(false));
//        }
//
//        // ساخت و ذخیره آدرس جدید
//        Address newAddress = Address.builder()
//                .title(createAddress.getTitle())
//                .address(createAddress.getAddress())
//                .postalCode(createAddress.getPostalCode())
//                .isDefault(Boolean.TRUE.equals(createAddress.getIsDefault()))
//                .customer(customer)
//                .build();
//
//        return addressRepository.save(newAddress);
//    }
//
//    @Override
//    public List<Address> getAllByUserId(Long userId) {
//        Customer customer = userUseCase.getById(userId);
//        return addressRepository.findByUserId(customer.getId());
//    }
//
//    @Override
//    public Address setDefaultAddress(Long userId, Long addressId) {
//
//        // دریافت کاربر
//        Customer customer = userUseCase.getById(userId);
//
//        // پیدا کردن آدرس موردنظر
//        Address addressToSet = addressRepository.findById(addressId)
//                .orElseThrow(() -> DomainException.of(ExceptionCode.ADDRESS_02));
//
//        // بررسی تعلق آدرس به کاربر
//        if (!addressToSet.getCustomer().getId().equals(userId)) {
//            throw DomainException.of(ExceptionCode.ADDRESS_03);
//        }
//
//        // اگر آدرس قبلاً دیفالت بوده، کاری لازم نیست
//        if (Boolean.TRUE.equals(addressToSet.getIsDefault())) {
//            return addressToSet;
//        }
//
//        // تمام آدرس‌های قبلی را false کن
//        customer.getAddresses().forEach(addr -> addr.setIsDefault(false));
//
//        // آدرس موردنظر را true کن
//        addressToSet.setIsDefault(true);
//
//        // ذخیره تغییرات
//        addressRepository.saveAll(customer.getAddresses()); // تغییرات سایر آدرس‌ها
//        return addressRepository.save(addressToSet);   // تغییرات آدرس جدید
//    }
//
//    @Override
//    public void deleteAddress(Long userId, Long addressId) {
//        // دریافت کاربر
//        Customer customer = userUseCase.getById(userId);
//
//        // پیدا کردن آدرس موردنظر
//        Address addressToDelete = addressRepository.findById(addressId)
//                .orElseThrow(() -> DomainException.of(ExceptionCode.ADDRESS_02));
//
//        // بررسی تعلق آدرس به کاربر
//        if (!addressToDelete.getCustomer().getId().equals(userId)) {
//            throw DomainException.of(ExceptionCode.ADDRESS_03);
//        }
//
//        addressRepository.delete(addressToDelete);
//    }
//}
