package com.git.sweetmanager.iam.interfaces.rest.resources;

public record AuthenticatedUserResource(Long id, String email, String token) {
}
