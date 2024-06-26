package com.git.sweetmanager.profile.domain.model.commands.customer;

public record CreateCustomerCommand(String name, String email, String phoneNumber, String reservationDate, String reservationTime, double cost) {
}