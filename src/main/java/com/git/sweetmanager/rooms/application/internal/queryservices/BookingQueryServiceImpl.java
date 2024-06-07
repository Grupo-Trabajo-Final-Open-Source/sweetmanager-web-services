package com.git.sweetmanager.rooms.application.internal.queryservices;

import com.git.sweetmanager.rooms.domain.model.aggregates.Booking;
import com.git.sweetmanager.rooms.domain.model.queries.GetAllBookingsQuery;
import com.git.sweetmanager.rooms.domain.model.queries.GetBookingByIdQuery;
import com.git.sweetmanager.rooms.domain.services.BookingQueryService;
import com.git.sweetmanager.rooms.infraestructure.persistence.mongo.repositories.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingQueryServiceImpl implements BookingQueryService {

    private BookingRepository bookingRepository;

    public BookingQueryServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Booking> handle(GetAllBookingsQuery query) {
        return bookingRepository.findAll();
    }

    @Override
    public Optional<Booking> handle(GetBookingByIdQuery query) {
        return bookingRepository.findById(query.bookingId());
    }
}
