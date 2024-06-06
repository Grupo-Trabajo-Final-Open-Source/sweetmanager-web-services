package com.git.sweetmanager.iam.interfaces.rest.transform;

import com.git.sweetmanager.iam.domain.model.aggregates.User;
import com.git.sweetmanager.iam.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {

    public static AuthenticatedUserResource toResourceFromEntity(User user, String token) {
        return new AuthenticatedUserResource(user.getId(), user.getEmail(), token);
    }
}
