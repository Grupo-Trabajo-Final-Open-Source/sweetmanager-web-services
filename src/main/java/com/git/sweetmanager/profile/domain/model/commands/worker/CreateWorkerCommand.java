package com.git.sweetmanager.profile.domain.model.commands.worker;

public record CreateWorkerCommand(String name, String email, String company, String role, String password) {
}
