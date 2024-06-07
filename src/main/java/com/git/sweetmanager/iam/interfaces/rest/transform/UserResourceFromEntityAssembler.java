package com.git.sweetmanager.iam.interfaces.rest.transform;

import com.git.sweetmanager.iam.domain.model.aggregates.User;
import com.git.sweetmanager.iam.domain.model.entities.Role;
import com.git.sweetmanager.iam.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User user) {
        var roles = user.getRoles().stream().map(Role::getStringName).toList();
        return new UserResource(user.getId(), user.getEmail(), roles);
    }
}
