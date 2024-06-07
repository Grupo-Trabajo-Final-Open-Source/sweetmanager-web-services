package com.git.sweetmanager.supply.domain.services;

import com.git.sweetmanager.supply.domain.model.aggregates.Supply;
import com.git.sweetmanager.supply.domain.model.queries.GetAllSuppliesQuery;
import com.git.sweetmanager.supply.domain.model.queries.GetSupplyByIdQuery;

import java.util.List;
import java.util.Optional;

public interface SupplyQueryService {
    List<Supply> handle(GetAllSuppliesQuery query);

    Optional<Supply> handle(GetSupplyByIdQuery query);
}
