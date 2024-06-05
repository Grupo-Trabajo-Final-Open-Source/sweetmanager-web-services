package com.git.sweetmanager.payment.interfaces.rest.transform;

import com.git.sweetmanager.payment.domain.model.commands.subscription.CreateSubscriptionCommand;

public class CreateSubscriptionCommandFromResourceAssembler {
    public  static CreateSubscriptionCommand toCommandFromResource(CreateSubscriptionCommand resource) {
        return new CreateSubscriptionCommand(resource.title(), resource.price(), resource.description());
    }
}
