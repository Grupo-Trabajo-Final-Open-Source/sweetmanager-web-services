package com.git.sweetmanager.profile.application.internal.commandservices.company;

import com.git.sweetmanager.profile.domain.model.aggregates.Companie;
import com.git.sweetmanager.profile.domain.model.commands.company.CreateCompanyCommand;
import com.git.sweetmanager.profile.domain.services.company.CompanyCommandService;
import com.git.sweetmanager.profile.infrastructure.persistence.mongo.repositories.company.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyCommandServiceImpl implements CompanyCommandService {
    private final CompanyRepository companyRepository;

    public CompanyCommandServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Optional<Companie> handle(CreateCompanyCommand command) {
        if(command.businessName() == null || command.businessName().isEmpty())
            throw new IllegalArgumentException("Business Name is required");
        if(command.ruc() == null || command.ruc().isEmpty())
            throw new IllegalArgumentException("RUC is required");

        var company = new Companie(command);

        companyRepository.save(company);

        return Optional.of(company);
    }
}