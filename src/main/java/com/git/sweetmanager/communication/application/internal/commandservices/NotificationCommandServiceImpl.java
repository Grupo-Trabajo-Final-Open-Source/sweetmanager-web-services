package com.git.sweetmanager.communication.application.internal.commandservices;

import com.git.sweetmanager.communication.domain.model.aggregates.Notification;
import com.git.sweetmanager.communication.domain.model.commands.CreateNotificationCommand;
import com.git.sweetmanager.communication.domain.services.NotificationCommandService;
import com.git.sweetmanager.communication.infrastructure.persistence.mongo.repositories.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotificationCommandServiceImpl implements NotificationCommandService {
    private final NotificationRepository notificationRepository;

    public NotificationCommandServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Optional<Notification> handle(CreateNotificationCommand command) {
        if(command.title() == null || command.title().isEmpty())
            throw new IllegalArgumentException("Title is required");
        if(command.date() == null)
            throw new IllegalArgumentException("Date is required");
        if(command.message() == null || command.message().isEmpty())
            throw new IllegalArgumentException("Message is required");

        var notification = new Notification(command);

        notificationRepository.save(notification);

        return Optional.of(notification);
    }
}
