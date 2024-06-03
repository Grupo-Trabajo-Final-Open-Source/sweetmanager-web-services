package com.git.sweetmanager.rooms.domain.model.commands;

import java.util.Date;

public record CreateBookingCommand(int clientId, int bedroomId,
                                   Date startDate, Date finalDate,
                                   float totalPrice, String state) {
}