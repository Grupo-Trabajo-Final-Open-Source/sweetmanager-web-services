package com.git.sweetmanager.rooms.interfaces.rest.resources;

import java.util.Date;

public record CreateBedroomResource(int typeBedroomId, int workerId, int totalBeds,
                                    int totalBathroom, int totalTelevision, String state) {
}
