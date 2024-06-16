package com.git.sweetmanager.rooms.interfaces.rest.resources;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

public record BookingResource(int clientId, int bedroomId,
                              LocalDate startDate, LocalDate finalDate,
                              float totalPrice, String state) {
}
