package com.git.sweetmanager.rooms.interfaces.rest.resources;

public record UpdateBedroomResource(int typeBedroomId, int workerId, int totalBeds,
                                    int totalBathroom, int totalTelevision, String state) {
}