package com.git.sweetmanager.iam.application.internal.commandservices;

import com.git.sweetmanager.iam.application.internal.outboundservices.hashings.HashingService;
import com.git.sweetmanager.iam.application.internal.outboundservices.tokens.TokenService;
import com.git.sweetmanager.iam.domain.model.aggregates.User;
import com.git.sweetmanager.iam.domain.model.commands.SignInCommand;
import com.git.sweetmanager.iam.domain.model.commands.SignUpCommand;
import com.git.sweetmanager.iam.domain.services.UserCommandService;
import com.git.sweetmanager.iam.infrastructure.persistence.mongo.repositories.RoleRepository;
import com.git.sweetmanager.iam.infrastructure.persistence.mongo.repositories.UserRepository;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class
UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;
    private final HashingService hashingService;
    private final TokenService tokenService;
    private final RoleRepository roleRepository;

    public UserCommandServiceImpl(UserRepository userRepository, HashingService hashingService, TokenService tokenService, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.hashingService = hashingService;
        this.tokenService = tokenService;
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<User> handle(SignUpCommand command) {
        if (userRepository.existsByEmail(command.email()))
            throw new RuntimeException("Username already exists");
        var roles = command.roles()
                .stream()
                .map(role -> roleRepository.findByName(role.getName())
                        .orElseThrow(() -> new RuntimeException("Role not found"))).toList();
        var user = new User(command.name(), command.email(), hashingService.encode(command.password()), roles);
        userRepository.save(user);
        return userRepository.findByEmail(command.email());
    }

    @Override
    public Optional<ImmutablePair<User, String>> handle(SignInCommand command) {
        var user = userRepository.findByEmail(command.email());
        if (user.isEmpty()) throw new RuntimeException("User not found");
        if (!hashingService.matches(command.password(), user.get().getPassword()))
            throw new RuntimeException("Invalid password");
        var token = tokenService.generateToken(user.get().getEmail());
        return Optional.of(ImmutablePair.of(user.get(), token));
    }
}
