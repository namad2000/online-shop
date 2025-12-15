package ir.shop.online.commons.domain.repository;

import java.util.Optional;

/**
 * Author: davood akbari
 * Email: daak1365@gmail.com
 * Created: 12/15/2025 10:08 PM
 * Package: ir.shop.online.commons.domain.repository
 */

public interface JpaRepository<D, ID> {
    void save(D domain);

    D update(D domain);

    Optional<D> findById(ID id);
}
