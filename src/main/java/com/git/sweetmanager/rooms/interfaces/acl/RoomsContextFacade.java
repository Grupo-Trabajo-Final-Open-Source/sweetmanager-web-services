package com.git.sweetmanager.rooms.interfaces.acl;

import com.git.sweetmanager.rooms.domain.model.aggregates.Bedroom;
import com.git.sweetmanager.rooms.domain.model.aggregates.Booking;
import com.git.sweetmanager.rooms.domain.model.commands.CreateBedroomCommand;
import com.git.sweetmanager.rooms.domain.model.commands.CreateBookingCommand;
import com.git.sweetmanager.rooms.domain.model.queries.GetBedroomByIdQuery;
import com.git.sweetmanager.rooms.domain.model.queries.GetBookingByIdQuery;
import com.git.sweetmanager.rooms.domain.services.BedroomCommandService;
import com.git.sweetmanager.rooms.domain.services.BedroomQueryService;
import com.git.sweetmanager.rooms.domain.services.BookingCommandService;
import com.git.sweetmanager.rooms.domain.services.BookingQueryService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Service
public class RoomsContextFacade {

    private BedroomCommandService bedroomCommandService;
    private BedroomQueryService bedroomQueryService;
    private BookingCommandService bookingCommandService;
    private BookingQueryService bookingQueryService;

    public RoomsContextFacade(BookingCommandService bookingCommandService,
                              BookingQueryService bookingQueryService,
                              BedroomCommandService bedroomCommandService,
                              BedroomQueryService bedroomQueryService) {
        this.bookingCommandService = bookingCommandService;
        this.bookingQueryService = bookingQueryService;
        this.bedroomCommandService = bedroomCommandService;
        this.bedroomQueryService = bedroomQueryService;
    }

    public Long createBedroom(int typeBedroomId, int workerId, int totalBeds,
                              int totalBathroom, int totalTelevision, String state)
    {
        var bedroom = bedroomCommandService.handle(new CreateBedroomCommand(typeBedroomId, workerId, totalBeds, totalBathroom, totalTelevision, state));

        if (bedroom.isEmpty()) return 0L;

        return bedroom.get().getId();
    }

    public Long createBooking(int clientId, int bedroomId,
                              LocalDate startDate, LocalDate finalDate,
                              float totalPrice, String state) {

        var booking = bookingCommandService.handle(new CreateBookingCommand(clientId, bedroomId, startDate, finalDate, totalPrice, state));

        if (booking.isEmpty()) return 0L;

        return booking.get().getId();
    }

    public Optional<Booking> fetchBookingById(Long bookingId)
    {
        return bookingQueryService.handle(new GetBookingByIdQuery(bookingId));
    }
    public Optional<Bedroom> fetchBedroomById(Long bedroomId)
    {
        return bedroomQueryService.handle(new GetBedroomByIdQuery(bedroomId));
    }
}
