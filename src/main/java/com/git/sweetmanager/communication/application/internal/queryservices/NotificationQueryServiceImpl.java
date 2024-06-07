package com.git.sweetmanager.communication.application.internal.queryservices;

import com.git.sweetmanager.communication.domain.model.aggregates.Notification;
import com.git.sweetmanager.communication.domain.model.queries.GetAllNotificationsQuery;
import com.git.sweetmanager.communication.domain.model.queries.GetNotificationByIdQuery;
import com.git.sweetmanager.communication.domain.services.NotificationQueryService;
import com.git.sweetmanager.communication.infrastructure.persistence.mongo.repositories.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationQueryServiceImpl implements NotificationQueryService {

    private final NotificationRepository notificationRepository;

    public NotificationQueryServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public List<Notification> handle(GetAllNotificationsQuery query) {
        return notificationRepository.findAll();
    }

    @Override
    public Optional<Notification> handle(GetNotificationByIdQuery query) {
        return notificationRepository.findById(query.notificationId());
    }
}
