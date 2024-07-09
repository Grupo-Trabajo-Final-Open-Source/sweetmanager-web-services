package com.git.sweetmanager.rooms.interfaces.rest;

import com.git.sweetmanager.rooms.domain.model.queries.GetAllBookingsQuery;
import com.git.sweetmanager.rooms.domain.model.queries.GetBookingByIdQuery;
import com.git.sweetmanager.rooms.domain.services.BookingCommandService;
import com.git.sweetmanager.rooms.domain.services.BookingQueryService;
import com.git.sweetmanager.rooms.interfaces.rest.resources.booking.BookingResource;
import com.git.sweetmanager.rooms.interfaces.rest.resources.booking.CreateBookingResource;
import com.git.sweetmanager.rooms.interfaces.rest.resources.booking.UpdateBookingResource;
import com.git.sweetmanager.rooms.interfaces.rest.transform.booking.BookingResourceFromEntityAssembler;
import com.git.sweetmanager.rooms.interfaces.rest.transform.booking.CreateBookingCommandFromResourceAssembler;
import com.git.sweetmanager.rooms.interfaces.rest.transform.booking.UpdateBookingCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/bookings", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Bookings", description = "Bookings Management Endpoints")
public class BookingController {
    private final BookingCommandService bookingCommandService;
    private final BookingQueryService bookingQueryService;

    public BookingController(BookingCommandService bookingCommandService, BookingQueryService bookingQueryService) {
        this.bookingCommandService = bookingCommandService;
        this.bookingQueryService = bookingQueryService;
    }

    @PostMapping("/bookings")
    public ResponseEntity<BookingResource> createBooking(@RequestBody CreateBookingResource resource)
    {
        var booking = bookingCommandService.handle(CreateBookingCommandFromResourceAssembler.toCommandFromResource(resource));

        if (booking.isEmpty()) return ResponseEntity.badRequest().build();

        var bookingResource = BookingResourceFromEntityAssembler.toResourceFromEntity(booking.get());

        return ResponseEntity.ok(bookingResource);
    }

    @PutMapping("/bookings")
    public ResponseEntity<BookingResource> updateBooking(@RequestBody UpdateBookingResource resource)
    {
        var booking = bookingCommandService.handle(UpdateBookingCommandFromResourceAssembler.toCommandFromResource(resource));

        if (booking.isEmpty()) return ResponseEntity.badRequest().build();

        var bookingResource = BookingResourceFromEntityAssembler.toResourceFromEntity(booking.get());

        return ResponseEntity.ok(bookingResource);
    }

    @GetMapping("/bookings")
    public ResponseEntity<List<BookingResource>> getAllBookings()
    {
        var bookings = bookingQueryService.handle(new GetAllBookingsQuery());

        var bookingResources = bookings.stream()
                .map(BookingResourceFromEntityAssembler::toResourceFromEntity)
                .toList();

        return ResponseEntity.ok(bookingResources);
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<BookingResource> getBookingById(@PathVariable Long bookingId)
    {
        var booking = bookingQueryService.handle(new GetBookingByIdQuery(bookingId));

        if (booking.isEmpty()) return ResponseEntity.badRequest().build();

        var bookingResource = BookingResourceFromEntityAssembler.toResourceFromEntity(booking.get());

        return ResponseEntity.ok(bookingResource);
    }
}
