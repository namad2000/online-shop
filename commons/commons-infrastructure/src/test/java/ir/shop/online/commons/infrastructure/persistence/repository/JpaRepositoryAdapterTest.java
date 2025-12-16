package ir.shop.online.commons.infrastructure.persistence.repository;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JpaRepositoryAdapterTest {

    @Mock
    private ApplicationContext applicationContext;

    @Mock
    private EntityManager entityManager;

    @Mock
    private TestMapper mapper;

    @InjectMocks
    private TestJpaRepositoryAdapter repository;

    private TestDomain domain;
    private TestEntity entity;

    @BeforeEach
    void setUp() {
        // هر بار mapper از ApplicationContext گرفته می‌شود
        when(applicationContext.getBean(TestMapper.class)).thenReturn(mapper);

        // نمونه‌های تستی
        domain = new TestDomain();
        domain.setId(1L);

        entity = new TestEntity();
        entity.setId(1L);
    }

    @Test
    void save_shouldPersistEntity_usingMapStructMapper() {
        when(mapper.toEntity(domain)).thenReturn(entity);

        repository.save(domain);

        verify(mapper).toEntity(domain);
        verify(entityManager).persist(entity);
    }

    @Test
    void update_shouldMergeAndReturnDomain() {
        when(mapper.toEntity(domain)).thenReturn(entity);
        when(entityManager.merge(entity)).thenReturn(entity);
        when(mapper.toDomain(entity)).thenReturn(domain);

        TestDomain result = repository.update(domain);

        assertNotNull(result);
        assertEquals(domain, result);
        verify(entityManager).merge(entity);
        verify(mapper).toDomain(entity);
    }

    @Test
    void findById_shouldReturnMappedDomain() {
        when(entityManager.find(TestEntity.class, 1L)).thenReturn(entity);
        when(mapper.toDomain(entity)).thenReturn(domain);

        Optional<TestDomain> result = repository.findById(1L);

        assertTrue(result.isPresent());
        assertEquals(domain, result.get());
        verify(entityManager).find(TestEntity.class, 1L);
        verify(mapper).toDomain(entity);
    }
}
