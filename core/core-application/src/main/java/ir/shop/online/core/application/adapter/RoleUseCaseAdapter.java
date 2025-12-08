package ir.shop.online.core.application.adapter;

import ir.shop.online.Infrastructure.repository.RoleRepository;
import ir.shop.online.commons.domain.annotation.UseCaseService;
import ir.shop.online.core.domain.usecase.RoleUseCase;
import ir.shop.online.domain.exception.DomainException;
import ir.shop.online.domain.exception.ExceptionCode;
import ir.shop.online.domain.model.entity.Role;
import lombok.RequiredArgsConstructor;

@UseCaseService
@RequiredArgsConstructor
public class RoleUseCaseAdapter implements RoleUseCase {

    private final RoleRepository roleRepository;

    @Override
    public Role getByName(String name) {
        return roleRepository.findByName(name)
                .orElseThrow(() -> new DomainException(ExceptionCode.ROLE_01));
    }
}
