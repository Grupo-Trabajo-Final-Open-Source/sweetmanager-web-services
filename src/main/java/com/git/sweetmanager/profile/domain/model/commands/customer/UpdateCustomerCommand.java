package com.git.sweetmanager.profile.domain.model.commands.customer;

public record UpdateCustomerCommand(Long id, String name, String email, String phoneNumber, String reservationDate, String reservationTime, double cost) {
}