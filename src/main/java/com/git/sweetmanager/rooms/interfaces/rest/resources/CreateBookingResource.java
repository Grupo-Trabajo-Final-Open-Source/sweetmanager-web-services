package com.git.sweetmanager.rooms.interfaces.rest.resources;

import java.time.LocalDate;
import java.util.Date;

public record CreateBookingResource(int clientId, int bedroomId,
                                    LocalDate startDate, LocalDate finalDate,
                                    float totalPrice, String state) {
}
