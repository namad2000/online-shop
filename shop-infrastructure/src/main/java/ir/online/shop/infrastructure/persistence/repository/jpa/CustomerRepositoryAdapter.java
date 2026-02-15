package ir.online.shop.infrastructure.persistence.repository.jpa;


import io.qoop.domain.model.PageData;
import ir.online.shop.domain.model.Customer;
import ir.online.shop.domain.repository.jpa.CustomerRepository;
import ir.online.shop.infrastructure.persistence.entity.CustomerEntity;
import ir.online.shop.infrastructure.persistence.mapper.CustomerMapper;
import ir.online.shop.infrastructure.persistence.repository.jpa.spring.CustomerJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CustomerRepositoryAdapter implements CustomerRepository {

    private final CustomerJpaRepository customerJpaRepository;
    private final CustomerMapper customerMapper;

    @Override
    public Customer save(Customer product) {
        CustomerEntity customerEntity = customerMapper.toEntity(product);
        customerEntity = customerJpaRepository.save(customerEntity);

        return customerMapper.toDomain(customerEntity);
    }

    @Override
    public Optional<Customer> findById(UUID id) {
        return customerJpaRepository.findById(id)
                .map(customerMapper::toDomain);
    }

    @Override
    public Boolean existById(UUID id) {
        return customerJpaRepository.existsById(id);
    }

    @Override
    public PageData<Customer> findAll(Integer pageNumber, Integer pageSize) {
        return null;
    }

    @Override
    public void delete(Customer domain, boolean logical) {
    }
}
