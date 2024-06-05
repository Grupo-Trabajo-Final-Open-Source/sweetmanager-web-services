package com.git.sweetmanager.profile.application.internal.queryservices.worker;

import com.git.sweetmanager.profile.domain.model.aggregates.Worker;
import com.git.sweetmanager.profile.domain.model.queries.worker.GetAllWorkersQuery;
import com.git.sweetmanager.profile.domain.model.queries.worker.GetWorkerByIdQuery;
import com.git.sweetmanager.profile.domain.services.worker.WorkerQueryService;
import com.git.sweetmanager.profile.infrastructure.persistence.mongo.repositories.worker.WorkerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerQueryServiceImpl implements WorkerQueryService {

    private final WorkerRepository workerRepository;

    public WorkerQueryServiceImpl(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    public List<Worker> handle(GetAllWorkersQuery query) {
        return workerRepository.findAll();
    }

    @Override
    public Optional<Worker> handle(GetWorkerByIdQuery query) {
        return workerRepository.findById(query.workerId());
    }
}