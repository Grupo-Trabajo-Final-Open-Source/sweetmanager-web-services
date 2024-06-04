package com.git.sweetmanager.supply.application.internal.queryservices;

import com.git.sweetmanager.supply.domain.model.aggregates.Supply;
import com.git.sweetmanager.supply.domain.model.queries.GetAllSuppliesQuery;
import com.git.sweetmanager.supply.domain.model.queries.GetSupplyByIdQuery;
import com.git.sweetmanager.supply.domain.services.SupplyQueryService;
import com.git.sweetmanager.supply.infrastructure.persistence.mongo.repositories.SupplyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplyQueryServiceImpl implements SupplyQueryService {
    private final SupplyRepository supplyRepository;
    public SupplyQueryServiceImpl(SupplyRepository supplyRepository) {
        this.supplyRepository = supplyRepository;
    }
    @Override
    public List<Supply> handle(GetAllSuppliesQuery query) {
        return supplyRepository.findAll();
    }
    @Override
    public Optional<Supply> handle(GetSupplyByIdQuery query) {
        return supplyRepository.findById(query.id());
    }
}
