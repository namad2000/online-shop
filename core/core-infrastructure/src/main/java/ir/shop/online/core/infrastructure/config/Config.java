package ir.shop.online.core.infrastructure.config;

import ir.shop.online.core.application.adapter.CategoryUseCaseAdapter;
import ir.shop.online.core.domain.repository.jpa.CategoryRepository;
import ir.shop.online.core.domain.usecase.CategoryUseCase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;

/**
 * Author: davood akbari
 * Email: daak1365@gmail.com
 * Created: 12/24/2025 7:25 PM
 * Package: ir.shop.online.core.infrastructure.config
 */

@Dependent
public class Config {

    @Inject
    CategoryRepository categoryRepository;

    @Produces
    @ApplicationScoped
    public CategoryUseCase categoryUseCase() {
        return new CategoryUseCaseAdapter(categoryRepository);
    }
}
