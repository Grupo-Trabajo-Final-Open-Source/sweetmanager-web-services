package com.git.sweetmanager.profile.interfaces;

import com.git.sweetmanager.profile.domain.model.queries.worker.GetAllWorkersQuery;
import com.git.sweetmanager.profile.domain.model.queries.worker.GetWorkerByIdQuery;
import com.git.sweetmanager.profile.domain.services.worker.WorkerCommandService;
import com.git.sweetmanager.profile.domain.services.worker.WorkerQueryService;
import com.git.sweetmanager.profile.interfaces.rest.resources.worker.CreateWorkerResource;
import com.git.sweetmanager.profile.interfaces.rest.resources.worker.WorkerResource;
import com.git.sweetmanager.profile.interfaces.rest.transform.worker.CreateWorkerCommandFromResourceAssembler;
import com.git.sweetmanager.profile.interfaces.rest.transform.worker.WorkerResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value= "/api/v1/workers", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Workers", description = "Worker Management Endpoints")
public class WorkerController {
    private final WorkerQueryService workerQueryService;

    private final WorkerCommandService workerCommandService;

    public WorkerController(WorkerQueryService workerQueryService, WorkerCommandService workerCommandService) {
        this.workerQueryService = workerQueryService;
        this.workerCommandService = workerCommandService;
    }

    @PostMapping
    public ResponseEntity<WorkerResource> createWorker(@RequestBody CreateWorkerResource resource) {
        var createWorkerCommand = CreateWorkerCommandFromResourceAssembler.toCommandFromResource(resource);

        var worker = workerCommandService.handle(createWorkerCommand);

        if (worker.isEmpty()) return ResponseEntity.badRequest().build();

        var workerResource = WorkerResourceFromEntityAssembler.toResourceFromEntity(worker.get());

        return new ResponseEntity<>(workerResource, HttpStatus.CREATED);
    }

    @GetMapping("/{workerId}")
    public ResponseEntity<WorkerResource> getWorkerById(@PathVariable Long workerId) {
        var getWorkerByIdQuery = new GetWorkerByIdQuery(workerId);

        var worker = workerQueryService.handle(getWorkerByIdQuery);

        if (worker.isEmpty()) return ResponseEntity.badRequest().build();

        var workerResource = WorkerResourceFromEntityAssembler.toResourceFromEntity(worker.get());

        return ResponseEntity.ok(workerResource);
    }

    @GetMapping
    public ResponseEntity<List<WorkerResource>> getAllWorkers() {
        var getAllWorkersQuery = new GetAllWorkersQuery();

        var workers = workerQueryService.handle(getAllWorkersQuery);

        var workerResources = workers.stream()
                .map(WorkerResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());

        return ResponseEntity.ok(workerResources);
    }
}