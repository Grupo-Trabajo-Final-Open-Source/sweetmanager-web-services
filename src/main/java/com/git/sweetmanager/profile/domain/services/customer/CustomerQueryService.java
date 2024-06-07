package com.git.sweetmanager.profile.domain.services.customer;

import com.git.sweetmanager.profile.domain.model.aggregates.Customer;
import com.git.sweetmanager.profile.domain.model.queries.customer.GetAllCustomersQuery;
import com.git.sweetmanager.profile.domain.model.queries.customer.GetCustomerByIdQuery;

import java.util.List;
import java.util.Optional;

public interface CustomerQueryService {
    List<Customer> handle(GetAllCustomersQuery query);

    Optional<Customer> handle(GetCustomerByIdQuery query);
}
