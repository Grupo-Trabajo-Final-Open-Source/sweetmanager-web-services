package com.git.sweetmanager.rooms.application.internal.commandservices;

import com.git.sweetmanager.rooms.domain.model.aggregates.Booking;
import com.git.sweetmanager.rooms.domain.model.commands.CreateBookingCommand;
import com.git.sweetmanager.rooms.domain.model.commands.UpdateBookingCommand;
import com.git.sweetmanager.rooms.domain.services.BookingCommandService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingCommandServiceImpl implements BookingCommandService {
    @Override
    public Optional<Booking> handle(CreateBookingCommand command) {
        return Optional.empty();
    }

    @Override
    public Optional<Booking> handle(UpdateBookingCommand command) {
        return Optional.empty();
    }
}
