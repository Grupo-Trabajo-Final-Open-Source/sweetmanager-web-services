package com.git.sweetmanager.iam.interfaces.rest.transform;

import com.git.sweetmanager.iam.domain.model.entities.Role;
import com.git.sweetmanager.iam.interfaces.rest.resources.RoleResource;

public class RoleResourceFromEntityAssembler {
    public static RoleResource toResourceFromEntity(Role role) {
        return new RoleResource(role.getId(), role.getStringName());
    }
}
