package com.git.sweetmanager.iam.application.internal.queryservices;

import com.git.sweetmanager.iam.domain.model.entities.Role;
import com.git.sweetmanager.iam.domain.model.queries.GetAllRolesQuery;
import com.git.sweetmanager.iam.domain.model.queries.GetRoleByNameQuery;
import com.git.sweetmanager.iam.domain.services.RoleQueryService;
import com.git.sweetmanager.iam.infrastructure.persistence.mongo.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleQueryServiceImpl implements RoleQueryService {
    private final RoleRepository roleRepository;

    public RoleQueryServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> handle(GetAllRolesQuery query) {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> handle(GetRoleByNameQuery query) {
        return roleRepository.findByName(query.roleName());
    }

}
