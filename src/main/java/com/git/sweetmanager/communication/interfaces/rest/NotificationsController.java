package com.git.sweetmanager.communication.interfaces.rest;

import com.git.sweetmanager.communication.domain.model.queries.GetAllNotificationsQuery;
import com.git.sweetmanager.communication.domain.model.queries.GetNotificationByIdQuery;
import com.git.sweetmanager.communication.domain.services.NotificationCommandService;
import com.git.sweetmanager.communication.domain.services.NotificationQueryService;
import com.git.sweetmanager.communication.interfaces.rest.resources.CreateNotificationResource;
import com.git.sweetmanager.communication.interfaces.rest.resources.NotificationResource;
import com.git.sweetmanager.communication.interfaces.rest.transform.CreateNotificationCommandFromResourceAssembler;
import com.git.sweetmanager.communication.interfaces.rest.transform.NotificationResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value= "/api/v1/notifications", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Notifications", description = "Notification Management Endpoints")
public class NotificationsController {
    private final NotificationQueryService notificationQueryService;

    private final NotificationCommandService notificationCommandService;

    public NotificationsController(NotificationQueryService notificationQueryService, NotificationCommandService notificationCommandService) {
        this.notificationQueryService = notificationQueryService;
        this.notificationCommandService = notificationCommandService;
    }

    @PostMapping
    public ResponseEntity<NotificationResource> createNotification(@RequestBody CreateNotificationResource resource) {
        var createNotificationCommand = CreateNotificationCommandFromResourceAssembler.toCommandFromResource(resource);

        var notification = notificationCommandService.handle(createNotificationCommand);

        if (notification.isEmpty()) return ResponseEntity.badRequest().build();

        var notificationResource = NotificationResourceFromEntityAssembler.toResourceFromEntity(notification.get());

        return new ResponseEntity<>(notificationResource, HttpStatus.CREATED);
    }

    @GetMapping("/{notificationId}")
    public ResponseEntity<NotificationResource> getNotificationById(@PathVariable Long notificationId) {
        var getNotificationByIdQuery = new GetNotificationByIdQuery(notificationId);

        var notification = notificationQueryService.handle(getNotificationByIdQuery);

        if (notification.isEmpty()) return ResponseEntity.badRequest().build();

        var notificationResource = NotificationResourceFromEntityAssembler.toResourceFromEntity(notification.get());

        return ResponseEntity.ok(notificationResource);
    }

    @GetMapping
    public ResponseEntity<List<NotificationResource>> getAllNotifications() {
        var getAllNotificationsQuery = new GetAllNotificationsQuery();

        var notifications = notificationQueryService.handle(getAllNotificationsQuery);

        var notificationResources = notifications.stream()
                .map(NotificationResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());

        return ResponseEntity.ok(notificationResources);
    }
}
