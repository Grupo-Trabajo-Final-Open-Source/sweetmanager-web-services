package com.git.sweetmanager.profile.application.internal.commandservices.worker;

import com.git.sweetmanager.profile.domain.model.aggregates.Worker;
import com.git.sweetmanager.profile.domain.model.commands.worker.CreateWorkerCommand;
import com.git.sweetmanager.profile.domain.services.worker.WorkerCommandService;
import com.git.sweetmanager.profile.infrastructure.persistence.mongo.repositories.worker.WorkerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WorkerCommandServiceImpl implements WorkerCommandService {
    private final WorkerRepository workerRepository;

    public WorkerCommandServiceImpl(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    public Optional<Worker> handle(CreateWorkerCommand command) {
        if(command.name() == null || command.name().isEmpty())
            throw new IllegalArgumentException("Name is required");
        if(command.email() == null || command.email().isEmpty())
            throw new IllegalArgumentException("Email is required");
        if(command.company() == null || command.company().isEmpty())
            throw new IllegalArgumentException("Company is required");
        if(command.role() == null || command.role().isEmpty())
            throw new IllegalArgumentException("Role is required");
        if(command.password() == null || command.password().isEmpty())
            throw new IllegalArgumentException("Password is required");

        var worker = new Worker(command);

        workerRepository.save(worker);

        return Optional.empty();
    }
}