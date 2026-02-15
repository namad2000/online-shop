package ir.online.shop.domain.repository.jpa;


import io.qoop.domain.repository.DomainRepository;
import ir.online.shop.domain.model.Customer;

import java.util.UUID;


public interface CustomerRepository extends DomainRepository<Customer, UUID> {
}
