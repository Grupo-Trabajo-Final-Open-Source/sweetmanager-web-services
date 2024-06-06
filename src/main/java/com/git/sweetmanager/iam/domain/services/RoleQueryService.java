package com.git.sweetmanager.iam.domain.services;

import com.git.sweetmanager.iam.domain.model.entities.Role;
import com.git.sweetmanager.iam.domain.model.queries.GetAllRolesQuery;
import com.git.sweetmanager.iam.domain.model.queries.GetRoleByNameQuery;

import java.util.List;
import java.util.Optional;

public interface RoleQueryService {
    List<Role> handle(GetAllRolesQuery query);

    Optional<Role> handle(GetRoleByNameQuery query);
}
