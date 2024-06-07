package com.git.sweetmanager.rooms.domain.services;

import com.git.sweetmanager.rooms.domain.model.aggregates.Booking;
import com.git.sweetmanager.rooms.domain.model.queries.GetAllBookingsQuery;
import com.git.sweetmanager.rooms.domain.model.queries.GetBookingByIdQuery;

import java.util.List;
import java.util.Optional;

public interface BookingQueryService {

    List<Booking> handle(GetAllBookingsQuery query);
    Optional<Booking> handle(GetBookingByIdQuery query);
}
