package com.git.sweetmanager.dashboard.application.internal.commandservices.provider;

import com.git.sweetmanager.dashboard.domain.model.aggregates.Provider;
import com.git.sweetmanager.dashboard.domain.model.commands.provider.CreateProviderCommand;
import com.git.sweetmanager.dashboard.domain.model.commands.provider.DeleteProviderCommand;
import com.git.sweetmanager.dashboard.domain.model.commands.provider.UpdateProviderCommand;
import com.git.sweetmanager.dashboard.domain.services.provider.ProviderCommandService;
import com.git.sweetmanager.dashboard.infrastructure.persistence.mongo.repositories.provider.ProviderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProviderCommandServiceImpl implements ProviderCommandService {
    private final ProviderRepository providerRepository;

    public ProviderCommandServiceImpl(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @Override
    public Optional<Provider> handle(CreateProviderCommand command) {
        if(command.name() == null || command.name().isEmpty())
            throw new IllegalArgumentException("Name is required");
        if(command.contact() == null || command.contact().isEmpty())
            throw new IllegalArgumentException("Contact is required");
        if(command.address() == null || command.address().isEmpty())
            throw new IllegalArgumentException("Address is required");
        if(command.product() == null || command.product().isEmpty())
            throw new IllegalArgumentException("Product is required");

        var provider = new Provider(command);

        providerRepository.save(provider);

        return Optional.of(provider);
    }


    @Override
    public Optional<Provider> handle(UpdateProviderCommand command) {
        if(command.name() == null || command.name().isEmpty())
            throw new IllegalArgumentException("Name is required");
        if(command.contact() == null || command.contact().isEmpty())
            throw new IllegalArgumentException("Contact is required");
        if(command.address() == null || command.address().isEmpty())
            throw new IllegalArgumentException("Address is required");
        if(command.product() == null || command.product().isEmpty())
            throw new IllegalArgumentException("Product is required");

        var provider = new Provider(command);

        providerRepository.save(provider);

        return Optional.of(provider);
    }

    @Override
    public void handle(DeleteProviderCommand command) {
        if(!providerRepository.existsById(command.id())){
            throw new IllegalArgumentException("Provider doesn't exist");
        }
        try{
            providerRepository.deleteById(command.id());
        } catch(Exception e){
            throw new IllegalArgumentException("Error occurred while deleting provider: " + e.getMessage());
        }
    }
}