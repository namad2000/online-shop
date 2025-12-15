package ir.shop.online.commons.infrastructure.persistence.repository;

import ir.shop.online.commons.domain.repository.JpaRepository;
import ir.shop.online.commons.infrastructure.persistence.mapper.InfraMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Optional;

/**
 * Author: davood akbari
 * Email: daak1365@gmail.com
 * Created: 12/9/2025 7:19 PM
 * Package: ir.shop.online.commons.infrastructure.repository
 */

public abstract class JpaRepositoryAdapter<D, E, ID> implements JpaRepository<D, ID> {

    @PersistenceContext
    protected EntityManager em;

    protected abstract InfraMapper<D, E> mapper();

    protected abstract Class<E> clazz();

    @Override
    public void save(D domain) {
        em.persist(mapper().toEntity(domain));
    }

    @Override
    public D update(D domain) {
        E entity = em.merge(mapper().toEntity(domain));
        return mapper().toDomain(entity);
    }

    @Override
    public Optional<D> findById(ID id) {
        E entity = em.find(clazz(), id);
        return Optional.of(mapper().toDomain(entity));
    }
}
