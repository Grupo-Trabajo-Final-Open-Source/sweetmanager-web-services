package com.git.sweetmanager.shared.domain.services;

import com.git.sweetmanager.shared.domain.aggregates.AuditableAbstractAggregateRoot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditableAbstractAggregateRootService {

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    public AuditableAbstractAggregateRoot createAuditableAbstractAggregateRoot() {
        AuditableAbstractAggregateRoot entity = new AuditableAbstractAggregateRoot();
        entity.setId(sequenceGeneratorService.generateSequence(AuditableAbstractAggregateRoot.class.getSimpleName(), AuditableAbstractAggregateRoot.class.getName()));
        return entity;
    }
}
