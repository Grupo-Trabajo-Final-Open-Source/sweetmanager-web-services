package com.git.sweetmanager.communication.interfaces.rest.resources;

import java.time.LocalDate;

public record NotificationResource(Long id, String title, String message, LocalDate date){
}
