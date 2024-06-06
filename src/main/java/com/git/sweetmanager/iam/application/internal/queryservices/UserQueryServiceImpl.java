package com.git.sweetmanager.iam.application.internal.queryservices;

import com.git.sweetmanager.iam.domain.model.aggregates.User;
import com.git.sweetmanager.iam.domain.model.queries.GetAllUsersQuery;
import com.git.sweetmanager.iam.domain.model.queries.GetUserByEmailQuery;
import com.git.sweetmanager.iam.domain.model.queries.GetUserByIdQuery;
import com.git.sweetmanager.iam.domain.services.UserQueryService;
import com.git.sweetmanager.iam.infrastructure.persistence.mongo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserQueryServiceImpl implements UserQueryService {
    private final UserRepository userRepository;

    public UserQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> handle(GetAllUsersQuery query) {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> handle(GetUserByIdQuery query) {
        return userRepository.findById(query.userId());
    }

    @Override
    public Optional<User> handle(GetUserByEmailQuery query) {
        return userRepository.findByEmail(query.emailUser());
    }
}
