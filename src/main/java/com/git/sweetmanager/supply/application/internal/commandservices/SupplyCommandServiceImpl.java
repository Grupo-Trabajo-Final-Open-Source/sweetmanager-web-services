package com.git.sweetmanager.supply.application.internal.commandservices;

import com.git.sweetmanager.supply.domain.model.aggregates.Supply;
import com.git.sweetmanager.supply.domain.model.commands.CreateSupplyCommand;
import com.git.sweetmanager.supply.domain.services.SupplyCommandService;
import com.git.sweetmanager.supply.infrastructure.persistence.mongo.repositories.SupplyRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SupplyCommandServiceImpl implements SupplyCommandService {
    private final SupplyRepository supplyRepository;
    public SupplyCommandServiceImpl(SupplyRepository supplyRepository) {
        this.supplyRepository = supplyRepository;
    }
    @Override
    public Optional<Supply> handle(CreateSupplyCommand command) {
        if(command.product() == null || command.product().isEmpty())
            throw new IllegalArgumentException("Product is required");
        if(command.quantity() == null)
            throw new IllegalArgumentException("Quantity is required (If there's none, place 0)");
        if(command.address() == null || command.address().isEmpty())
            throw new IllegalArgumentException("Address is required");
        if(command.expire() == null)
            throw new IllegalArgumentException("Expire date is required");

        var supply = new Supply(command);
        supplyRepository.save(supply);
        return Optional.empty();
    }
}
