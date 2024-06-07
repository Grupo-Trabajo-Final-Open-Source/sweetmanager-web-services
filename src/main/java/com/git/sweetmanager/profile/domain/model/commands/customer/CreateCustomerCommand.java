package com.git.sweetmanager.profile.domain.model.commands.customer;

public record CreateCustomerCommand(String name, String dni, int age, String email) {
}
