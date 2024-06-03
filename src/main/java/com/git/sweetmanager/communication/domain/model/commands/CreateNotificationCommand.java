package com.git.sweetmanager.communication.domain.model.commands;

import java.time.LocalDate;
import java.util.Date;

public record CreateNotificationCommand(String title, String message, LocalDate date) {
}
