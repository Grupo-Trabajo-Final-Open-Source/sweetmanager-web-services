package com.git.sweetmanager.rooms.interfaces.rest;

import com.git.sweetmanager.rooms.domain.model.queries.GetAllBedroomsQuery;
import com.git.sweetmanager.rooms.domain.model.queries.GetAllBookingsQuery;
import com.git.sweetmanager.rooms.domain.model.queries.GetBedroomByIdQuery;
import com.git.sweetmanager.rooms.domain.model.queries.GetBookingByIdQuery;
import com.git.sweetmanager.rooms.domain.services.BedroomCommandService;
import com.git.sweetmanager.rooms.domain.services.BedroomQueryService;
import com.git.sweetmanager.rooms.domain.services.BookingCommandService;
import com.git.sweetmanager.rooms.domain.services.BookingQueryService;
import com.git.sweetmanager.rooms.interfaces.rest.resources.bedroom.BedroomResource;
import com.git.sweetmanager.rooms.interfaces.rest.resources.bedroom.CreateBedroomResource;
import com.git.sweetmanager.rooms.interfaces.rest.resources.bedroom.UpdateBedroomResource;
import com.git.sweetmanager.rooms.interfaces.rest.resources.booking.BookingResource;
import com.git.sweetmanager.rooms.interfaces.rest.resources.booking.CreateBookingResource;
import com.git.sweetmanager.rooms.interfaces.rest.resources.booking.UpdateBookingResource;
import com.git.sweetmanager.rooms.interfaces.rest.transform.bedroom.BedroomResourceFromEntityAssembler;
import com.git.sweetmanager.rooms.interfaces.rest.transform.bedroom.CreateBedroomCommandFromResourceAssembler;
import com.git.sweetmanager.rooms.interfaces.rest.transform.bedroom.UpdateBedroomCommandFromResourceAssembler;
import com.git.sweetmanager.rooms.interfaces.rest.transform.booking.BookingResourceFromEntityAssembler;
import com.git.sweetmanager.rooms.interfaces.rest.transform.booking.CreateBookingCommandFromResourceAssembler;
import com.git.sweetmanager.rooms.interfaces.rest.transform.booking.UpdateBookingCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/rooms", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name="Rooms", description = "Rooms Management Endpoints")
public class RoomsController {

    private final BedroomCommandService bedroomCommandService;

    private final BedroomQueryService bedroomQueryService;


    public RoomsController(BedroomCommandService bedroomCommandService, BedroomQueryService bedroomQueryService) {
        this.bedroomCommandService = bedroomCommandService;
        this.bedroomQueryService = bedroomQueryService;
    }

    @PostMapping()
    public ResponseEntity<BedroomResource> createBedroom(@RequestBody CreateBedroomResource resource)
    {
        var bedroom = bedroomCommandService.handle(CreateBedroomCommandFromResourceAssembler.toCommandFromResource(resource));

        if (bedroom.isEmpty()) return ResponseEntity.badRequest().build();

        var bedroomResource = BedroomResourceFromEntityAssembler.toResourceFromEntity(bedroom.get());

        return ResponseEntity.ok(bedroomResource);
    }

    @PutMapping()
    public ResponseEntity<BedroomResource> updateBedroom(@RequestBody UpdateBedroomResource resource)
    {
        var bedroom = bedroomCommandService.handle(UpdateBedroomCommandFromResourceAssembler.toCommandFromResource(resource));

        if (bedroom.isEmpty()) return ResponseEntity.badRequest().build();

        var bedroomResource = BedroomResourceFromEntityAssembler.toResourceFromEntity(bedroom.get());

        return ResponseEntity.ok(bedroomResource);
    }

    @GetMapping()
    public ResponseEntity<List<BedroomResource>> getAllBedrooms()
    {
        var bedrooms = bedroomQueryService.handle(new GetAllBedroomsQuery());

        var bedroomResources = bedrooms.stream()
                .map(BedroomResourceFromEntityAssembler::toResourceFromEntity)
                .toList();

        return ResponseEntity.ok(bedroomResources);
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