package com.git.sweetmanager.rooms.domain.model.commands;

public record CreateBedroomCommand(String worker, int totalBeds, String clientName,
                                   int totalBathroom, int totalTelevision, String state, String name, String description, Double price) {
}
