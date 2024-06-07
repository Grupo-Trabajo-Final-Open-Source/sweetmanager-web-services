package com.git.sweetmanager.shared.domain.services;

import com.git.sweetmanager.shared.domain.entities.DatabaseSequence;
import com.git.sweetmanager.shared.domain.entities.SequenceException;
import jakarta.annotation.Resource;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class SequenceGeneratorService {
    @Resource
    private MongoOperations mongoOperations;

    public long generateSequence(String seqName, String collectionName) {
        long seqIdValue;
        do {
            Query query = new Query(Criteria.where("_id").is(seqName));
            Update update = new Update().inc("seq", 1);
            FindAndModifyOptions options = new FindAndModifyOptions().returnNew(true);
            DatabaseSequence seqId = mongoOperations.findAndModify(query, update, options, DatabaseSequence.class);

            if (seqId == null) {
                throw new SequenceException("Unable to get sequence id for key : " + seqName);
            }
            seqIdValue = seqId.getSeq();
        } while(mongoOperations.exists(new Query(Criteria.where("_id").is(seqIdValue)), collectionName));
        return seqIdValue;
    }
}
