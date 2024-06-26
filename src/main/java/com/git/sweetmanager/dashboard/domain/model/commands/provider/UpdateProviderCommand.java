package com.git.sweetmanager.dashboard.domain.model.commands.provider;

public record UpdateProviderCommand(Long id, String name, String contact, String address, String product) {
}
