package com.git.sweetmanager.profile.domain.services.company;

import com.git.sweetmanager.profile.domain.model.aggregates.Companie;
import com.git.sweetmanager.profile.domain.model.commands.company.CreateCompanyCommand;

import java.util.Optional;

public interface CompanyCommandService {
    Optional<Companie> handle(CreateCompanyCommand command);
}

