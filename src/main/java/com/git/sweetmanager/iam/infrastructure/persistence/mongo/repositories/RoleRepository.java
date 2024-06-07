package com.git.sweetmanager.iam.infrastructure.persistence.mongo.repositories;

import com.git.sweetmanager.iam.domain.model.entities.Role;
import com.git.sweetmanager.iam.domain.model.valueobjects.Roles;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends MongoRepository<Role, Long> {
    Optional<Role> findByName(Roles name);

    boolean existsByName(Roles name);
}
