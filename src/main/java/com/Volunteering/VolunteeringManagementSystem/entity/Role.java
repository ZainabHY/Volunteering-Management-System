package com.Volunteering.VolunteeringManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbl_role")
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Role implements Employee{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer roleId;

    private String roleName;
    private String username;
    private String password;

    @Embedded
    private ContactInfo contactInfo;

    @Enumerated
    private RoleType roleType;

    public Role() {}

    // Constructor for all the common attributes for Manager and Volunteer
    // WITHOUT id and roleType
    public Role(String roleName, String username, String password, ContactInfo contactInfo) {
        this.roleName = roleName;
        this.username = username;
        this.password = password;
        this.contactInfo = contactInfo;
    }

    // Constructor for all attributes in Role
    public Role(String roleName, String username, String password, ContactInfo contactInfo, RoleType roleType) {
        this.roleName = roleName;
        this.username = username;
        this.password = password;
        this.contactInfo = contactInfo;
        this.roleType = roleType;
    }


// METHODS
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
