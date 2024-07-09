package com.git.sweetmanager.rooms.interfaces.rest.transform.booking;

import com.git.sweetmanager.rooms.domain.model.aggregates.Booking;
import com.git.sweetmanager.rooms.interfaces.rest.resources.booking.BookingResource;

public class BookingResourceFromEntityAssembler {

    public static BookingResource toResourceFromEntity(Booking entity) {

        return new BookingResource(entity.GetClientId(),
                entity.GetBedroomId(), entity.GetStartDate(),
                entity.GetFinalDate(), entity.GetTotalPrice(),
                entity.GetState());
    }
}
