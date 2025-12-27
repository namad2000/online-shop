package ir.shop.online.commons.util.mapper;

import java.util.List;

public interface InputMapper<C, D> {

    D toDomain(C input, MappingContext context);

    default D toDomain(C input) {
        return toDomain(input, MappingContext.empty());
    }

    default List<D> toDomain(List<C> inputs, MappingContext context) {
        return inputs.stream()
                .map(c -> toDomain(c, context))
                .toList();
    }
}

