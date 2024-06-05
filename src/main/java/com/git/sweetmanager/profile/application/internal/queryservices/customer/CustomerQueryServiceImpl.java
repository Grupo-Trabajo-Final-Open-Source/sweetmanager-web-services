package com.git.sweetmanager.profile.application.internal.queryservices.customer;

import com.git.sweetmanager.profile.domain.model.aggregates.Customer;
import com.git.sweetmanager.profile.domain.model.queries.customer.GetAllCustomersQuery;
import com.git.sweetmanager.profile.domain.model.queries.customer.GetCustomerByIdQuery;
import com.git.sweetmanager.profile.domain.services.customer.CustomerQueryService;
import com.git.sweetmanager.profile.infrastructure.persistence.mongo.repositories.customer.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerQueryServiceImpl implements CustomerQueryService {

    private final CustomerRepository customerRepository;

    public CustomerQueryServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> handle(GetAllCustomersQuery query) {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> handle(GetCustomerByIdQuery query) {
        return customerRepository.findById(query.customerId());
    }
}