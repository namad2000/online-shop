package ir.online.shop.domain.service;

import io.qoop.fault.handler.api.exception.DomainException;
import io.qoop.filter.bean.api.DomainService;
import ir.online.shop.domain.model.Customer;
import ir.online.shop.domain.repository.jpa.CustomerRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

import static ir.online.shop.domain.exception.CustomerExceptionCode.CUSTOMER_NOT_FOUND;

/**
 * Author: davood akbari
 * Email: daak1365@gmail.com
 * Created: 12/27/2025 12:46 PM
 * Package: ir.online.shop.domain.service
 */

@DomainService
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Customer create(Customer newCustomer) {
        return customerRepository.save(newCustomer);
    }

    public Customer getById(UUID customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> DomainException.of(CUSTOMER_NOT_FOUND));
    }
}
