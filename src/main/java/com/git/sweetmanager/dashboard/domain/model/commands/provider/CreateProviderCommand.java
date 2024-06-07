package com.git.sweetmanager.dashboard.domain.model.commands.provider;

public record CreateProviderCommand(String name, String contact, String address, String product) {
}
