package com.Volunteering.VolunteeringManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Role implements Employee{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    private String roleName;
    private String username;
    private String password;

    @Embedded
    private ContactInfo contactInfo;

    @Enumerated
    private RoleType roleType;

    public Role() {}


    public Role(String roleName, String username, String password, ContactInfo contactInfo, RoleType roleType) {
        this.roleName = roleName;
        this.username = username;
        this.password = password;
        this.contactInfo = contactInfo;
        this.roleType = roleType;
    }

    // Mathods
    // Validate credentials to ensure that user is authorized to access the system
    public void validateCredentials()
    {

    }

    public String changePassword()
    {

        return "Your password has changed successfully!";
    }

    public void signUp(Role role)
    {

    }
    public void login(String username, String password)
    {

    }
}
