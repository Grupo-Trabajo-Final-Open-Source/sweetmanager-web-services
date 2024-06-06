package com.git.sweetmanager.iam.domain.services;

import com.git.sweetmanager.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {

    void handle(SeedRolesCommand command);

}
