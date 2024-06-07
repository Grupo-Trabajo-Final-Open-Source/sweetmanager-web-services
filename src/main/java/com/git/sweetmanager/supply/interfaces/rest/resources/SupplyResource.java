package com.git.sweetmanager.supply.interfaces.rest.resources;

public record SupplyResource(Long id, String product, Number quantity, String address, String expire) {
}
