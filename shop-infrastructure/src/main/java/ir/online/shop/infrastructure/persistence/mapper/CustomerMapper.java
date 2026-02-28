package ir.online.shop.infrastructure.persistence.mapper;

import io.qoop.mapper.core.CommonsMapperConfig;
import io.qoop.mapper.core.mapstruct.BasicMapper;
import ir.online.shop.domain.model.Customer;
import ir.online.shop.infrastructure.persistence.entity.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(config = CommonsMapperConfig.class)
public interface CustomerMapper extends BasicMapper<Customer, CustomerEntity> {
    Customer toDomain(CustomerEntity entity);

    CustomerEntity toEntity(Customer domain);
}
