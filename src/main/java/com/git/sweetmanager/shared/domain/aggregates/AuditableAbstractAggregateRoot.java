package com.git.sweetmanager.shared.domain.aggregates;

import com.git.sweetmanager.shared.domain.services.SequenceGeneratorService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import lombok.Getter;
import java.util.Date;

@Getter
@Document
public class AuditableAbstractAggregateRoot<T extends AbstractAggregateRoot<T>>extends AbstractAggregateRoot<T> {

    @Id
    @Getter
    @Setter
    private Long id;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

}
