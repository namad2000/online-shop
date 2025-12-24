package ir.shop.online.commons.util.mapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public interface Mapper<I, O> {

    O map(I in, MappingContext context);

    default O map(I in) {
        return map(in, MappingContext.empty());
    }

    default List<O> mapList(List<I> inputs, MappingContext context) {
        return inputs.stream()
                .map(i -> map(i, context))
                .toList();
    }

    default Set<O> mapSet(Set<I> inputs, MappingContext context) {
        return inputs.stream()
                .map(i -> map(i, context))
                .collect(Collectors.toSet());
    }
}
