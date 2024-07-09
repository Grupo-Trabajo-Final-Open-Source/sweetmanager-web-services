package com.git.sweetmanager.rooms.domain.model.commands;

public record UpdateBedroomCommand(long id, String worker, int totalBeds, String clientName,
                                   int totalBathroom, int totalTelevision, String state, String name, String description, Double price) {
}
