package com.git.sweetmanager.rooms.domain.model.commands;

public record CreateBedroomCommand(int typeBedroomId, int workerId, int totalBeds,
                                   int totalBathroom, int totalTelevision, String state) {
}
