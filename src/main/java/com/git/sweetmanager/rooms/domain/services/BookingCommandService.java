package com.git.sweetmanager.rooms.domain.services;

import com.git.sweetmanager.rooms.domain.model.aggregates.Booking;
import com.git.sweetmanager.rooms.domain.model.commands.CreateBookingCommand;
import com.git.sweetmanager.rooms.domain.model.commands.UpdateBookingCommand;

import java.util.Optional;

public interface BookingCommandService {

    Optional<Booking> handle(CreateBookingCommand command);
    Optional<Booking> handle(UpdateBookingCommand command);
}