package com.git.sweetmanager.dashboard.interfaces.rest.transform.provider;

import com.git.sweetmanager.dashboard.domain.model.aggregates.Provider;
import com.git.sweetmanager.dashboard.interfaces.rest.resources.provider.ProviderResource;

public class ProviderResourceFromEntityAssembler {
    public static ProviderResource toResourceFromEntity(Provider entity) {
        return new ProviderResource(entity.getId(), entity.getName(), entity.getContact(), entity.getAddress(), entity.getProduct());
    }
}