package com.git.sweetmanager.rooms.domain.model.commands;

public record UpdateBedroomCommand(long id, int typeBedroomId, int workerId, int totalBeds,
                                   int totalBathroom, int totalTelevision, String state) {
}
