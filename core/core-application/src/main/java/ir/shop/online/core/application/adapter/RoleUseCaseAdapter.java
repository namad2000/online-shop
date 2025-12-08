package ir.shop.online.core.application.adapter;


import ir.shop.online.commons.domain.annotation.UseCaseService;
import ir.shop.online.commons.domain.exception.DomainBusinessException;
import ir.shop.online.core.domain.model.role.Role;
import ir.shop.online.core.domain.repository.jpa.RoleRepository;
import ir.shop.online.core.domain.usecase.RoleUseCase;
import lombok.RequiredArgsConstructor;

import static ir.shop.online.core.domain.exception.ExceptionCode.ROLE_01;

@UseCaseService
@RequiredArgsConstructor
public class RoleUseCaseAdapter implements RoleUseCase {

    private final RoleRepository roleRepository;

    @Override
    public Role getByName(String name) {
        return roleRepository.findByName(name)
                .orElseThrow(() -> new DomainBusinessException(ROLE_01.name()));
    }
}
