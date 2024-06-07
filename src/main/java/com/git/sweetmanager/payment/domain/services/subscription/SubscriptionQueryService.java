package com.git.sweetmanager.payment.domain.services.subscription;

import com.git.sweetmanager.payment.domain.model.aggregates.Subscription;
import com.git.sweetmanager.payment.domain.model.queries.subscription.GetAllSubscriptionsQuery;
import com.git.sweetmanager.payment.domain.model.queries.subscription.GetSubscriptionByIdQuery;

import java.util.List;
import java.util.Optional;

public interface SubscriptionQueryService {
    List<Subscription> handle(GetAllSubscriptionsQuery query);

    Optional<Subscription> handle(GetSubscriptionByIdQuery query);
}
