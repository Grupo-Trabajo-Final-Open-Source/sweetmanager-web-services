package com.git.sweetmanager.rooms.domain.model.commands;

public record UpdateBedroomCommand(int typeBedroomId, int workerId, int totalBeds,
                                   int totalBathroom, int totalTelevision, String state) {
}
