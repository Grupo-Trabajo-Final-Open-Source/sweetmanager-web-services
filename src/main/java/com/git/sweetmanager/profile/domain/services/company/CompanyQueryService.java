package com.git.sweetmanager.profile.domain.services.company;

import com.git.sweetmanager.profile.domain.model.aggregates.Companie;
import com.git.sweetmanager.profile.domain.model.queries.company.GetAllCompaniesQuery;
import com.git.sweetmanager.profile.domain.model.queries.company.GetCompanyByIdQuery;

import java.util.List;
import java.util.Optional;

public interface CompanyQueryService {
    List<Companie> handle(GetAllCompaniesQuery query);

    Optional<Companie> handle(GetCompanyByIdQuery query);
}
