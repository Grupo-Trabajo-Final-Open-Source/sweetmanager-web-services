package com.git.sweetmanager.profile.interfaces.rest.transform.company;

import com.git.sweetmanager.profile.domain.model.aggregates.Companie;
import com.git.sweetmanager.profile.interfaces.rest.resources.company.CompanyResource;

public class CompanyResourceFromEntityAssembler {
    public static CompanyResource toResourceFromEntity(Companie entity) {
        return new CompanyResource(entity.getId(), entity.getBusinessName(), entity.getRuc());
    }
}