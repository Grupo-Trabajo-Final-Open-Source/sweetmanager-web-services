package com.git.sweetmanager.communication.interfaces.rest.resources;

import java.time.LocalDate;

public record CreateNotificationResource(String title, LocalDate date, String message) {
}
