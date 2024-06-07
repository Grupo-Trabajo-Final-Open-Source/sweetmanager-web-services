package com.git.sweetmanager.payment.interfaces.rest.transform.subscription;

import com.git.sweetmanager.payment.domain.model.aggregates.Subscription;
import com.git.sweetmanager.payment.interfaces.rest.resources.subscription.SubscriptionResource;

public class SubscriptionResourceFromEntityAssembler {

    public static SubscriptionResource toResourceFromEntity(Subscription entity) {
        return new SubscriptionResource(entity.getId(), entity.getTitle(), entity.getPrice(), entity.getDescription());
    }
}
