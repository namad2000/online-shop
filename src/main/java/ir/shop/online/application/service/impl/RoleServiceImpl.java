package ir.shop.online.application.service.impl;

import ir.shop.online.Infrastructure.repository.RoleRepository;
import ir.shop.online.application.service.RoleService;
import ir.shop.online.domain.exception.DomainException;
import ir.shop.online.domain.exception.ExceptionCode;
import ir.shop.online.domain.model.entity.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role getByName(String name) {
        return roleRepository.findByName(name)
                .orElseThrow(() -> new DomainException(ExceptionCode.ROLE_01));
    }
}
