package com.git.sweetmanager.profile.interfaces.rest.transform.worker;

import com.git.sweetmanager.profile.domain.model.aggregates.Worker;
import com.git.sweetmanager.profile.interfaces.rest.resources.worker.WorkerResource;

public class WorkerResourceFromEntityAssembler {
    public static WorkerResource toResourceFromEntity(Worker entity) {
        return new WorkerResource(entity.getId(), entity.getName(), entity.getEmail(), entity.getCompany(), entity.getRole(), entity.getPassword());
    }
}