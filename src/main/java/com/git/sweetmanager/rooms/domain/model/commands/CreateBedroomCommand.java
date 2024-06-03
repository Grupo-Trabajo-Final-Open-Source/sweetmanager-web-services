package com.git.sweetmanager.rooms.domain.model.commands;

public record CreateBedroomCommand(int type_bedroom_id, int worker_id, int totalBeds,
                                   int totalBathroom, int totalTelevision, String state) {
}
