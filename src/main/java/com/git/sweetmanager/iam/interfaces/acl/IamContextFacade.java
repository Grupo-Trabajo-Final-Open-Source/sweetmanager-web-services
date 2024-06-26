package com.git.sweetmanager.iam.interfaces.acl;

import com.git.sweetmanager.iam.domain.model.commands.SignUpCommand;
import com.git.sweetmanager.iam.domain.model.entities.Role;
import com.git.sweetmanager.iam.domain.model.queries.GetUserByEmailQuery;
import com.git.sweetmanager.iam.domain.model.queries.GetUserByIdQuery;
import com.git.sweetmanager.iam.domain.services.UserCommandService;
import com.git.sweetmanager.iam.domain.services.UserQueryService;
import org.apache.logging.log4j.util.Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * IamContextFacade
 * <p>
 *     This class is a facade for the IAM context. It provides a simple interface for other bounded contexts to interact with the
 *     IAM context.
 *     This class is a part of the ACL layer.
 * </p>
 *
 */
public class IamContextFacade {
    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    public IamContextFacade(UserCommandService userCommandService, UserQueryService userQueryService) {
        this.userCommandService = userCommandService;
        this.userQueryService = userQueryService;
    }

    /**
     * Creates a user with the given username and password.
     * @param email The username of the user.
     * @param password The password of the user.
     * @return The id of the created user.
     */
    public Long createUser(String name, String email, String password, int companyId) {
        var signUpCommand = new SignUpCommand(name, email, password, List.of(Role.getDefaultRole()), companyId);
        var result = userCommandService.handle(signUpCommand);
        if (result.isEmpty()) return 0L;
        return result.get().getId();
    }

    /**
     * Creates a user with the given username, password and roles.
     * @param email The username of the user.
     * @param password The password of the user.
     * @param roleNames The names of the roles of the user. When a role does not exist, it is ignored.
     * @return The id of the created user.
     */
    public Long createUser(String name, String email, String password, List<String> roleNames, int companyId) {
        var roles = roleNames != null ? roleNames.stream().map(Role::toRoleFromName).toList() : new ArrayList<Role>();
        var signUpCommand = new SignUpCommand(name ,email, password, roles, companyId);
        var result = userCommandService.handle(signUpCommand);
        if (result.isEmpty()) return 0L;
        return result.get().getId();
    }

    /**
     * Fetches the id of the user with the given username.
     * @param email The username of the user.
     * @return The id of the user.
     */
    public Long fetchUserIdByEmail(String email) {
        var getUserByUsernameQuery = new GetUserByEmailQuery(email);
        var result = userQueryService.handle(getUserByUsernameQuery);
        if (result.isEmpty()) return 0L;
        return result.get().getId();
    }

    /**
     * Fetches the username of the user with the given id.
     * @param userId The id of the user.
     * @return The username of the user.
     */
    public String fetchEmailByUserId(Long userId) {
        var getUserByIdQuery = new GetUserByIdQuery(userId);
        var result = userQueryService.handle(getUserByIdQuery);
        if (result.isEmpty()) return Strings.EMPTY;
        return result.get().getEmail();
    }

}
