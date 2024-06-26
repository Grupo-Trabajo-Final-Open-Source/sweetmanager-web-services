package com.git.sweetmanager.supply.domain.model.commands;

public record UpdateSupplyCommand(Long id, String product, Number quantity, String address, String expire) { }
