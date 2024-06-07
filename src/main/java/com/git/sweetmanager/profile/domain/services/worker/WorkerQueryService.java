package com.git.sweetmanager.profile.domain.services.worker;

import com.git.sweetmanager.profile.domain.model.aggregates.Worker;
import com.git.sweetmanager.profile.domain.model.queries.worker.GetAllWorkersQuery;
import com.git.sweetmanager.profile.domain.model.queries.worker.GetWorkerByIdQuery;

import java.util.List;
import java.util.Optional;

public interface WorkerQueryService {
    List<Worker> handle(GetAllWorkersQuery query);

    Optional<Worker> handle(GetWorkerByIdQuery query);
}
