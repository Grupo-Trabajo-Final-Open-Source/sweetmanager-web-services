package com.git.sweetmanager.supply.application.internal.commandservices;

import com.git.sweetmanager.supply.domain.model.aggregates.Supplie;
import com.git.sweetmanager.supply.domain.model.commands.CreateSupplyCommand;
import com.git.sweetmanager.supply.domain.model.commands.DeleteSupplyCommand;
import com.git.sweetmanager.supply.domain.model.commands.UpdateSupplyCommand;
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
    public Optional<Supplie> handle(CreateSupplyCommand command) {
        if(command.product() == null || command.product().isEmpty())
            throw new IllegalArgumentException("Product is required");
        if(command.quantity() == null)
            throw new IllegalArgumentException("Quantity is required (If there's none, place 0)");
        if(command.address() == null || command.address().isEmpty())
            throw new IllegalArgumentException("Address is required");
        if(command.expire() == null)
            throw new IllegalArgumentException("Expire date is required");

        var supply = new Supplie(command);
        supplyRepository.save(supply);
        return Optional.of(supply);
    }

    @Override
    public Optional<Supplie> handle(UpdateSupplyCommand command) {
        if(command.product() == null || command.product().isEmpty())
            throw new IllegalArgumentException("Product is required");
        if(command.quantity() == null)
            throw new IllegalArgumentException("Quantity is required (If there's none, place 0)");
        if(command.address() == null || command.address().isEmpty())
            throw new IllegalArgumentException("Address is required");
        if(command.expire() == null)
            throw new IllegalArgumentException("Expire date is required");

        try{
            var supply = new Supplie(command);

            supplyRepository.save(supply);

            return Optional.of(supply);
        }
        catch(Exception ex){
            return Optional.empty();
        }
    }

    @Override
    public Optional<Supplie> handle(DeleteSupplyCommand command) {
        if(!supplyRepository.existsById(command.id())) {
            throw new IllegalArgumentException("Supply doesn't exist");
        }
        try{
            var supply = supplyRepository.findById(command.id());

            supplyRepository.deleteById(command.id());

            return Optional.of(supply.get());
        }
        catch(Exception ex){
            return Optional.empty();
        }
    }
}
