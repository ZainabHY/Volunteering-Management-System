package com.Volunteering.VolunteeringManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
public abstract class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    private String roleName;
    private String username;
    private String password;

    @Embedded
    private ContactInfo contactInfo;

    public Role() {}

    public Role(String roleName, String username, String password, ContactInfo contactInfo) {
        this.roleName = roleName;
        this.username = username;
        this.password = password;
        this.contactInfo = contactInfo;
    }

    // Mathods
    public void validateCredentials()
    {

    }

    public String changePassword()
    {

        return "Your password has changed successfully!";
    }
}
