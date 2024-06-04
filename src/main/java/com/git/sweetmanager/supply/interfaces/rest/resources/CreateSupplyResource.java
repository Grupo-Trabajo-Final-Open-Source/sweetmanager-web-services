package com.git.sweetmanager.supply.interfaces.rest.resources;

public record CreateSupplyResource(String product, Number quantity, String address, String expire) {
}
