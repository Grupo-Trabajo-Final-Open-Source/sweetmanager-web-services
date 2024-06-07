package com.git.sweetmanager.profile.interfaces.rest.transform.company;

import com.git.sweetmanager.profile.domain.model.commands.company.CreateCompanyCommand;
import com.git.sweetmanager.profile.interfaces.rest.resources.company.CreateCompanyResource;

public class CreateCompanyCommandFromResourceAssembler {
    public static CreateCompanyCommand toCommandFromResource(CreateCompanyResource resource) {
        return new CreateCompanyCommand(resource.businessName(), resource.RUC());
    }
}