package com.git.sweetmanager.rooms.domain.model.commands;

import java.time.LocalDate;
import java.util.Date;

public record CreateBookingCommand(int clientId, int bedroomId,
                                   LocalDate startDate, LocalDate finalDate,
                                   float totalPrice, String state) {
}