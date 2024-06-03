package com.git.sweetmanager.communication.interfaces.rest.transform;

import com.git.sweetmanager.communication.domain.model.aggregates.Notification;
import com.git.sweetmanager.communication.interfaces.rest.resources.NotificationResource;

public class NotificationResourceFromEntityAssembler {
    public static NotificationResource toResourceFromEntity(Notification entity) {
        return new NotificationResource(entity.getId(), entity.getTitle(), entity.getMessage(), entity.getDate());
    }
}
