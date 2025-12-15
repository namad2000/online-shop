package ir.shop.online.commons.infrastructure.persistence.mapper;

/**
 * Author: davood akbari
 * Email: daak1365@gmail.com
 * Created: 12/15/2025 10:18 PM
 * Package: ir.shop.online.commons.infrastructure.persistence.mapper
 */

public interface InfraMapper<D, E> {

    D toDomain(E e);

    E toEntity(D d);
}
