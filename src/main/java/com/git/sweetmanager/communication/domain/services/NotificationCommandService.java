package com.git.sweetmanager.communication.domain.services;

import com.git.sweetmanager.communication.domain.model.aggregates.Notification;
import com.git.sweetmanager.communication.domain.model.commands.CreateNotificationCommand;

import java.util.Optional;

public interface NotificationCommandService {
    Optional<Notification> handle(CreateNotificationCommand command);
}
