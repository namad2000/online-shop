package ir.shop.online.commons.infrastructure.persistence.repository;

import ir.shop.online.commons.infrastructure.persistence.mapper.CommonsInfrastructureMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TestMapper extends CommonsInfrastructureMapper<TestDomain, TestEntity> {
}
