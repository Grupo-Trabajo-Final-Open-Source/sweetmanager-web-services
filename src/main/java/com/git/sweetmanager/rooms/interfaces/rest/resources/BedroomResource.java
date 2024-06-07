package com.git.sweetmanager.rooms.interfaces.rest.resources;

public record BedroomResource(int typeBedroomId, int workerId, int totalBeds,
                              int totalBathroom, int totalTelevision, String state) {
}
