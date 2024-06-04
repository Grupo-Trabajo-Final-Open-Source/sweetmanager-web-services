package com.git.sweetmanager.supply.domain.model.commands;

public record CreateSupplyCommand(String product, Number quantity, String address, String expire) {

}