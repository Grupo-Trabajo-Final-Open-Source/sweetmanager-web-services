package com.git.sweetmanager.shared.domain.entities;

import com.git.sweetmanager.shared.domain.aggregates.AuditableAbstractAggregateRoot;
import com.git.sweetmanager.shared.domain.services.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@Component
public class ModelListener extends AbstractMongoEventListener<Object> {

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Object> event) {
        Object source = event.getSource();
        if (source instanceof AuditableAbstractAggregateRoot) {
            AuditableAbstractAggregateRoot entity = (AuditableAbstractAggregateRoot) source;
            if (entity.getId() == null) {
                String collectionName = entity.getClass().getSimpleName().toLowerCase() + "s";
                entity.setId(sequenceGeneratorService.generateSequence(entity.getClass().getSimpleName(), collectionName));
            }
        }
    }
}
