package com.git.sweetmanager.rooms.interfaces.rest.resources.bedroom;

public record BedroomResource(Long id, String clientName, String workName, int totalBeds, int totalBathroom, int totalTelevision,
                              String state, String name, String description, Double price){
}
