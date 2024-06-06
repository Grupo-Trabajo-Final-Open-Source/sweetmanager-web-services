package com.git.sweetmanager.iam.application.internal.commandservices;

import com.git.sweetmanager.iam.domain.model.commands.SeedRolesCommand;
import com.git.sweetmanager.iam.domain.model.entities.Role;
import com.git.sweetmanager.iam.domain.model.valueobjects.Roles;
import com.git.sweetmanager.iam.domain.services.RoleCommandService;
import com.git.sweetmanager.iam.infrastructure.persistence.mongo.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class RoleCommandServiceImpl implements RoleCommandService {
    private final RoleRepository roleRepository;

    public RoleCommandServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void handle(SeedRolesCommand command) {
        Arrays.stream(Roles.values()).forEach(role -> {
            if(!roleRepository.existsByName(role)) {
                roleRepository.save(new Role(Roles.valueOf(role.name())));
            }
        });
    }
}
