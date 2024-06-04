package com.git.sweetmanager.rooms.application.internal.queryservices;

import com.git.sweetmanager.rooms.domain.model.aggregates.Booking;
import com.git.sweetmanager.rooms.domain.model.queries.GetAllBookingsQuery;
import com.git.sweetmanager.rooms.domain.model.queries.GetBookingByIdQuery;
import com.git.sweetmanager.rooms.domain.services.BookingQueryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingQueryServiceImpl implements BookingQueryService {
    @Override
    public List<Booking> handle(GetAllBookingsQuery query) {
        return List.of();
    }

    @Override
    public Optional<Booking> handle(GetBookingByIdQuery query) {
        return Optional.empty();
    }
}
