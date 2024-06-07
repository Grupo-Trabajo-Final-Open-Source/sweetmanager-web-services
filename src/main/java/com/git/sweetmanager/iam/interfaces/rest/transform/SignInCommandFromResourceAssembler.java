package com.git.sweetmanager.iam.interfaces.rest.transform;

import com.git.sweetmanager.iam.domain.model.commands.SignInCommand;
import com.git.sweetmanager.iam.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource signInResource) {
        return new SignInCommand(signInResource.email(), signInResource.password());
    }
}
