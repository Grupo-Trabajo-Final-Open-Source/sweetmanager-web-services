package com.git.sweetmanager.iam.interfaces.rest.transform;

import com.git.sweetmanager.iam.domain.model.commands.SignUpCommand;
import com.git.sweetmanager.iam.domain.model.entities.Role;
import com.git.sweetmanager.iam.interfaces.rest.resources.SignUpResource;

import java.util.ArrayList;

public class SignUpCommandFromResourceAssembler {
    public static SignUpCommand toCommandFromResource(SignUpResource resource) {
        var roles = resource.roles() != null ? resource.roles().stream().map(name -> Role.toRoleFromName(name)).toList() : new ArrayList<Role>();
        return new SignUpCommand(resource.email(), resource.password(), roles);
    }
}
