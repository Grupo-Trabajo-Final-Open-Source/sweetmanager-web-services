package com.git.sweetmanager.rooms.interfaces.rest;

import com.git.sweetmanager.rooms.domain.model.queries.GetAllBedroomsQuery;
import com.git.sweetmanager.rooms.domain.model.queries.GetAllBookingsQuery;
import com.git.sweetmanager.rooms.domain.model.queries.GetBedroomByIdQuery;
import com.git.sweetmanager.rooms.domain.model.queries.GetBookingByIdQuery;
import com.git.sweetmanager.rooms.domain.services.BedroomCommandService;
import com.git.sweetmanager.rooms.domain.services.BedroomQueryService;
import com.git.sweetmanager.rooms.domain.services.BookingCommandService;
import com.git.sweetmanager.rooms.domain.services.BookingQueryService;
import com.git.sweetmanager.rooms.interfaces.rest.resources.*;
import com.git.sweetmanager.rooms.interfaces.rest.transform.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/rooms", produces = MediaType.APPLICATION_JSON_VALUE)
public class RoomsController {

    private final BookingCommandService bookingCommandService;
    private final BookingQueryService bookingQueryService;
    private final BedroomCommandService bedroomCommandService;
    private final BedroomQueryService bedroomQueryService;


    public RoomsController(BookingCommandService bookingCommandService, BookingQueryService bookingQueryService, BedroomCommandService bedroomCommandService, BedroomQueryService bedroomQueryService) {
        this.bookingCommandService = bookingCommandService;
        this.bookingQueryService = bookingQueryService;
        this.bedroomCommandService = bedroomCommandService;
        this.bedroomQueryService = bedroomQueryService;
    }

    @PostMapping
    public ResponseEntity<BookingResource> createBooking(@RequestBody CreateBookingResource resource)
    {
        var booking = bookingCommandService.handle(CreateBookingCommandFromResourceAssembler.toCommandFromResource(resource));

        if (booking.isEmpty()) return ResponseEntity.badRequest().build();

        var bookingResource = BookingResourceFromEntityAssembler.toResourceFromEntity(booking.get());

        return ResponseEntity.ok(bookingResource);
    }

    @PostMapping
    public ResponseEntity<BedroomResource> createBedroom(@RequestBody CreateBedroomResource resource)
    {
        var bedroom = bedroomCommandService.handle(CreateBedroomCommandFromResourceAssembler.toCommandFromResource(resource));

        if (bedroom.isEmpty()) return ResponseEntity.badRequest().build();

        var bedroomResource = BedroomResourceFromEntityAssembler.toResourceFromEntity(bedroom.get());

        return ResponseEntity.ok(bedroomResource);
    }

    @PutMapping
    public ResponseEntity<BookingResource> updateBooking(@RequestBody UpdateBookingResource resource)
    {
        var booking = bookingCommandService.handle(UpdateBookingCommandFromResourceAssembler.toCommandFromResource(resource));

        if (booking.isEmpty()) return ResponseEntity.badRequest().build();

        var bookingResource = BookingResourceFromEntityAssembler.toResourceFromEntity(booking.get());

        return ResponseEntity.ok(bookingResource);
    }

    @PutMapping
    public ResponseEntity<BedroomResource> updateBedroom(@RequestBody UpdateBedroomResource resource)
    {
        var bedroom = bedroomCommandService.handle(UpdateBedroomCommandFromResourceAssembler.toCommandFromResource(resource));

        if (bedroom.isEmpty()) return ResponseEntity.badRequest().build();

        var bedroomResource = BedroomResourceFromEntityAssembler.toResourceFromEntity(bedroom.get());

        return ResponseEntity.ok(bedroomResource);
    }

    @GetMapping
    public ResponseEntity<List<BookingResource>> getAllBookings()
    {
        var bookings = bookingQueryService.handle(new GetAllBookingsQuery());

        var bookingResources = bookings.stream()
                .map(BookingResourceFromEntityAssembler::toResourceFromEntity)
                .toList();

        return ResponseEntity.ok(bookingResources);
    }

    @GetMapping
    public ResponseEntity<List<BedroomResource>> getAllBedrooms()
    {
        var bedrooms = bedroomQueryService.handle(new GetAllBedroomsQuery());

        var bedroomResources = bedrooms.stream()
                .map(BedroomResourceFromEntityAssembler::toResourceFromEntity)
                .toList();

        return ResponseEntity.ok(bedroomResources);
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<BookingResource> getBookingById(@PathVariable Long bookingId)
    {
        var booking = bookingQueryService.handle(new GetBookingByIdQuery(bookingId));

        if (booking.isEmpty()) return ResponseEntity.badRequest().build();

        var bookingResource = BookingResourceFromEntityAssembler.toResourceFromEntity(booking.get());

        return ResponseEntity.ok(bookingResource);
    }

    @GetMapping("/{bedroomId}")
    public ResponseEntity<BedroomResource> getBedroomById(@PathVariable Long bedroomId)
    {
        var bedroom = bedroomQueryService.handle(new GetBedroomByIdQuery(bedroomId));

        if (bedroom.isEmpty()) return ResponseEntity.badRequest().build();

        var bedroomResource = BedroomResourceFromEntityAssembler.toResourceFromEntity(bedroom.get());

        return ResponseEntity.ok(bedroomResource);
    }
}