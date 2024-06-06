package com.git.sweetmanager.iam.domain.model.entities;

import com.git.sweetmanager.iam.domain.model.valueobjects.Roles;
import com.git.sweetmanager.shared.domain.aggregates.AuditableAbstractAggregateRoot;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "roles")
public class Role extends AuditableAbstractAggregateRoot<Role> {

    @Getter
    private Roles name;

    public Role(){

    }

    public Role(Roles name){
        this.name= name;
    }

    public String getStringName(){
        return name.name();
    }

    public static Role getDefaultRole(){
        return new Role(Roles.ROLE_MANAGER);
    }

    public static Role toRoleFromName(String name){
        return new Role(Roles.valueOf(name));
    }

    public static List<Role> validateRoleSet(List<Role> roles){
        if(roles == null || roles.isEmpty()){
            return List.of(getDefaultRole());
        }

        return roles;
    }
}
