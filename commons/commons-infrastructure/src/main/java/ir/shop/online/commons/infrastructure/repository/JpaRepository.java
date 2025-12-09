package ir.shop.online.commons.infrastructure.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * Author: davood akbari
 * Email: daak1365@gmail.com
 * Created: 12/9/2025 7:19 PM
 * Package: ir.shop.online.commons.infrastructure.repository
 */
public abstract class JpaRepository<D, E, ID> {

    @PersistenceContext
    protected EntityManager em;
}
