package com.git.sweetmanager.profile.application.internal.queryservices.company;

import com.git.sweetmanager.profile.domain.model.aggregates.Company;
import com.git.sweetmanager.profile.domain.model.queries.company.GetAllCompaniesQuery;
import com.git.sweetmanager.profile.domain.model.queries.company.GetCompanyByIdQuery;
import com.git.sweetmanager.profile.domain.services.company.CompanyQueryService;
import com.git.sweetmanager.profile.infrastructure.persistence.mongo.repositories.company.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyQueryServiceImpl implements CompanyQueryService {

    private final CompanyRepository companyRepository;

    public CompanyQueryServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> handle(GetAllCompaniesQuery query) {
        return companyRepository.findAll();
    }

    @Override
    public Optional<Company> handle(GetCompanyByIdQuery query) {
        return companyRepository.findById(query.companyId());
    }
}