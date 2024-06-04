package com.git.sweetmanager.payment.application.internal.queryservices;

import com.git.sweetmanager.payment.domain.model.aggregates.Subscription;
import com.git.sweetmanager.payment.domain.model.queries.GetAllSubscriptionsQuery;
import com.git.sweetmanager.payment.domain.model.queries.GetSubscriptionByIdQuery;
import com.git.sweetmanager.payment.domain.services.SubscriptionQueryService;
import com.git.sweetmanager.payment.infrastructure.persistence.mongo.repositories.SubscriptionRepository;

import java.util.List;
import java.util.Optional;

public class SubscriptionQueryServiceImpl implements SubscriptionQueryService {

    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionQueryServiceImpl(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public List<Subscription> handle(GetAllSubscriptionsQuery query) {
        return subscriptionRepository.findAll();
    }

    @Override
    public Optional<Subscription> handle(GetSubscriptionByIdQuery query) {
        return subscriptionRepository.findById(query.subscriptionId());
    }

}
