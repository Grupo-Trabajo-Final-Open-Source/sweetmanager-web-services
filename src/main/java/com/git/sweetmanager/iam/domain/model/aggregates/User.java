package com.git.sweetmanager.iam.domain.model.aggregates;

import com.git.sweetmanager.shared.domain.aggregates.AuditableAbstractAggregateRoot;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.git.sweetmanager.iam.domain.model.entities.Role;

@Document(collection = "users")
public class User extends AuditableAbstractAggregateRoot<User> {

    @Getter
    private String name;

    @Getter
    private String email;

    @Getter
    private String password;

    @Getter
    private Set<Role> roles;

    // Constructor

    public User(){
        this.roles = new HashSet<>();
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = new HashSet<>();
    }

    public User(String email, String password, List<Role> roles) {
        this.email = email;
        this.password = password;
        addRoles(roles);
    }

    public User addRole(Role role){
        this.roles.add(role);
        return this;
    }

    public User addRoles(List<Role> roles){
        var validatedRoles = Role.validateRoleSet(roles);

        this.roles.addAll(validatedRoles);

        return this;
    }

}