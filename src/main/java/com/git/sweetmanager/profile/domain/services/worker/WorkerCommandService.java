package com.git.sweetmanager.profile.domain.services.worker;

import com.git.sweetmanager.profile.domain.model.aggregates.Worker;
import com.git.sweetmanager.profile.domain.model.commands.worker.CreateWorkerCommand;

import java.util.Optional;

public interface WorkerCommandService {
    Optional<Worker> handle(CreateWorkerCommand command);
}
