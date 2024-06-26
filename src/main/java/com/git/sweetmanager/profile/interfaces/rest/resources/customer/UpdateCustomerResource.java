package com.git.sweetmanager.profile.interfaces.rest.resources.customer;

public record UpdateCustomerResource(Long id, String name, String email, String phoneNumber, String reservationDate, String reservationTime, double cost) {
}