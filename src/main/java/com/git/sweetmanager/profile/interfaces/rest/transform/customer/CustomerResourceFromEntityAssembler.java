package com.git.sweetmanager.profile.interfaces.rest.transform.customer;

import com.git.sweetmanager.profile.domain.model.aggregates.Customer;
import com.git.sweetmanager.profile.interfaces.rest.resources.customer.CustomerResource;

public class CustomerResourceFromEntityAssembler {
    public static CustomerResource toResourceFromEntity(Customer entity) {
        return new CustomerResource(entity.getId(), entity.getName(), entity.getDni(), entity.getAge(), entity.getEmail());
    }
}