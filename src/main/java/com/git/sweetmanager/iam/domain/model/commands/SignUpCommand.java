package com.git.sweetmanager.iam.domain.model.commands;

import com.git.sweetmanager.iam.domain.model.entities.Role;

import java.util.List;

public record SignUpCommand(String name, String email, String password, List<Role> roles, int companyId) {
}
