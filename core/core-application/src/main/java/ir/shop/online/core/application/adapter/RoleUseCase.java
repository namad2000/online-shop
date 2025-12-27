package ir.shop.online.core.application.adapter;


import ir.shop.online.commons.domain.annotation.UseCaseService;
import ir.shop.online.commons.domain.exception.DomainBusinessException;
import ir.shop.online.core.domain.model.Role;
import ir.shop.online.core.domain.repository.jpa.RoleRepository;
import lombok.RequiredArgsConstructor;

import static ir.shop.online.core.domain.exception.ExceptionCode.ROLE_01;

@UseCaseService
@RequiredArgsConstructor
public class RoleUseCase {

    private final RoleRepository roleRepository;

    public Role getByName(String name) {
        return roleRepository.findByName(name)
                .orElseThrow(() -> new DomainBusinessException(ROLE_01.name()));
    }
}
