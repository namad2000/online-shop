package ir.online.shop.domain.repository.jpa;

import io.qoop.domain.repository.DomainRepository;
import ir.online.shop.domain.model.Vendor;

import java.util.UUID;


public interface VendorRepository  extends DomainRepository<Vendor, UUID>  {
}
