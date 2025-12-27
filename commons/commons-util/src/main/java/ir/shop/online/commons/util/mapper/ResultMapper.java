package ir.shop.online.commons.util.mapper;

import java.util.Set;
import java.util.stream.Collectors;

public interface ResultMapper<D, R> {

    R toResult(D domain, MappingContext context);

    default R toResult(D domain) {
        return toResult(domain, MappingContext.empty());
    }

    default Set<R> toResult(Set<D> domains, MappingContext context) {
        return domains.stream()
                .map(o -> toResult(o, context))
                .collect(Collectors.toSet());
    }
}

