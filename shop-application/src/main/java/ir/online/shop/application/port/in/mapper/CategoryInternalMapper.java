package ir.online.shop.application.port.in.mapper;

import io.qoop.filter.bean.api.DomainMapper;
import ir.online.shop.application.port.in.model.cmd.category.CreateCategoryCmd;
import ir.online.shop.application.port.in.model.cmd.category.UpdateCategoryCmd;
import ir.online.shop.application.port.in.model.result.category.CategoryResult;
import ir.online.shop.domain.model.Category;
import ir.online.shop.domain.model.Media;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@DomainMapper
public class CategoryInternalMapper {

    // ---------- Command → Domain ----------
    public Category toDomain(CreateCategoryCmd command) {
        if (command == null) return null;

        return Category.builder()
                .name(command.getName())
                .description(command.getDescription())
                .slug(command.getSlug())
                .featured(command.getFeatured())
                .orderIndex(command.getOrderIndex())
                .build();
    }

    public Category toDomain(UpdateCategoryCmd command) {
        if (command == null) return null;

        return Category.builder()
                .id(command.getId())
                .name(command.getName())
                .description(command.getDescription())
                .slug(command.getSlug())
                .active(command.getActive())
                .featured(command.getFeatured())
                .orderIndex(command.getOrderIndex())
                .parent(Category.builder().id(command.getParentId()).build())
                .medias(Set.of(Media.builder().id(command.getMediaId()).build()))
                .build();
    }

    // ---------- Domain → Result ----------
    public CategoryResult toResult(Category category) {
        if (category == null) return null;

        return CategoryResult.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
//                .slug(category.getSlug())
//                .active(category.getActive())
//                .featured(category.getFeatured())
//                .orderIndex(category.getOrderIndex())
//                .parentId(category.getParentId())
                .children(category.getChildren() == null ? Set.of() :
                        category.getChildren().stream()
                                .map(this::toResult) // برای UseCase، recursion امن است ولی در Controller maxDepth کنترل می‌شود
                                .collect(Collectors.toSet()))
                .build();
    }

    public List<CategoryResult> toResultList(List<Category> categories) {
        if (categories == null) return List.of();
        return categories.stream().map(this::toResult).collect(Collectors.toList());
    }
}
