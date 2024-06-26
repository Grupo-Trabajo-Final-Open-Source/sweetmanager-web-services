package com.git.sweetmanager.iam.domain.services;

import com.git.sweetmanager.iam.domain.model.aggregates.User;
import com.git.sweetmanager.iam.domain.model.queries.GetAllUsersQuery;
import com.git.sweetmanager.iam.domain.model.queries.GetUserByCompanyIdQuery;
import com.git.sweetmanager.iam.domain.model.queries.GetUserByEmailQuery;
import com.git.sweetmanager.iam.domain.model.queries.GetUserByIdQuery;

import java.util.List;
import java.util.Optional;

public interface UserQueryService {

    List<User> handle(GetAllUsersQuery query);

    Optional<User> handle(GetUserByIdQuery query);

    Optional<User> handle(GetUserByEmailQuery query);

    Optional<User> handle(GetUserByCompanyIdQuery query);
}
