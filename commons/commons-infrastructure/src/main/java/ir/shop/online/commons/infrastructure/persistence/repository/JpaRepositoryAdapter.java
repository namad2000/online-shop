package ir.shop.online.commons.infrastructure.persistence.repository;

import ir.shop.online.commons.domain.repository.JpaRepository;
import ir.shop.online.commons.infrastructure.persistence.mapper.CommonsInfrastructureMapper;
import ir.shop.online.commons.util.card.reflection.TypeReference;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

/**
 * Author: davood akbari
 * Email: daak1365@gmail.com
 * Created: 12/9/2025 7:19 PM
 * Package: ir.shop.online.commons.infrastructure.repository
 */

public abstract class JpaRepositoryAdapter<D, E, ID, M extends CommonsInfrastructureMapper<D, E>> implements JpaRepository<D, ID>, TypeReference {

    @Autowired
    private ApplicationContext applicationContext;

    @PersistenceContext
    protected EntityManager em;

    protected CommonsInfrastructureMapper<D, E> mapper() {
        return applicationContext.getBean(this.genericClass(3));
    }

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
        E entity = em.find(this.genericClass(1), id);
        return Optional.of(mapper().toDomain(entity));
    }
}
