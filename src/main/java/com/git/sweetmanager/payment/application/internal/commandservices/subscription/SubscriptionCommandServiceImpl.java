package com.git.sweetmanager.payment.application.internal.commandservices.subscription;

import com.git.sweetmanager.payment.domain.model.aggregates.Subscription;
import com.git.sweetmanager.payment.domain.model.commands.subscription.CreateSubscriptionCommand;
import com.git.sweetmanager.payment.domain.services.subscription.SubscriptionCommandService;
import com.git.sweetmanager.payment.infrastructure.persistence.mongo.repositories.subscription.SubscriptionRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubscriptionCommandServiceImpl implements SubscriptionCommandService {

    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionCommandServiceImpl(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public Optional<Subscription> handle(CreateSubscriptionCommand command) {
        if(command.title() == null || command.title().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        if(command.price() == null || command.price() == 0){
            throw new IllegalArgumentException("Price cannot be null or empty");
        }
        if(command.description() == null || command.description().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty");
        }

        var subscription = new Subscription(command);

        return Optional.of(subscription);
    }

}
