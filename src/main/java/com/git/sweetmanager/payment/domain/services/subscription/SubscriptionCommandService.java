package com.git.sweetmanager.payment.domain.services.subscription;

import com.git.sweetmanager.payment.domain.model.aggregates.Subscription;
import com.git.sweetmanager.payment.domain.model.commands.subscription.CreateSubscriptionCommand;

import java.util.Optional;

public interface SubscriptionCommandService {

    Optional<Subscription> handle(CreateSubscriptionCommand command);

}
