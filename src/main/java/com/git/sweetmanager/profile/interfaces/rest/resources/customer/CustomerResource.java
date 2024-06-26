package com.git.sweetmanager.profile.interfaces.rest.resources.customer;

public record CustomerResource(Long id, String name, String email, String phoneNumber, String reservationDate, String reservationTime, double cost) {
}