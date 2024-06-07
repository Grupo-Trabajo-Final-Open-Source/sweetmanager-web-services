package com.git.sweetmanager.communication.domain.services;

import com.git.sweetmanager.communication.domain.model.aggregates.Notification;
import com.git.sweetmanager.communication.domain.model.queries.GetAllNotificationsQuery;
import com.git.sweetmanager.communication.domain.model.queries.GetNotificationByIdQuery;

import java.util.List;
import java.util.Optional;

public interface NotificationQueryService {
    List<Notification> handle(GetAllNotificationsQuery query);

    Optional<Notification> handle(GetNotificationByIdQuery query);

}
