package com.git.sweetmanager.supply.domain.services;

import com.git.sweetmanager.supply.domain.model.aggregates.Supplie;
import com.git.sweetmanager.supply.domain.model.queries.GetAllSuppliesQuery;
import com.git.sweetmanager.supply.domain.model.queries.GetSupplyByIdQuery;

import java.util.List;
import java.util.Optional;

public interface SupplyQueryService {
    List<Supplie> handle(GetAllSuppliesQuery query);
    Optional<Supplie> handle(GetSupplyByIdQuery query);
}
