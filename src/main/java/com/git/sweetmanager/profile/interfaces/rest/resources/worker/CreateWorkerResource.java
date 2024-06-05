package com.git.sweetmanager.profile.interfaces.rest.resources.worker;

public record CreateWorkerResource(String name, String email, String company, String role, String password) {
}
