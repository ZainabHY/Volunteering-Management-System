package com.Volunteering.VolunteeringManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.HibernateException;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tbl_role")
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Role implements Employee{

    // Generate custom ID for each of manager and volunteer
    @Id
//    @GeneratedValue(strategy = GenerationType.TABLE)
//    @GeneratedValue(generator = "custom-id")
//    @GenericGenerator(name = "custom-id", strategy = "com.example.CustomIdGenerator")
    private String roleId;

    private String roleName;
    private String username;
    private String password;

    @Embedded
    private ContactInfo contactInfo;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    public Role() {}

    // Constructor for all the common attributes for Manager and Volunteer
    // WITHOUT id and roleType
    public Role(String roleName, String username, String password, ContactInfo contactInfo) {
        this.roleId = customIdGenerator(this); // Call the method to generate custom ID
        this.roleName = roleName;
        this.username = username;
        this.password = password;
        this.contactInfo = contactInfo;
    }

    // Constructor for all attributes in Role
    public Role(String roleName, String username, String password, ContactInfo contactInfo, RoleType roleType) {
        this.roleId = customIdGenerator(this); // Call the method to generate custom ID
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

    //////////

    // Generate custom ID for each of manager and volunteer
    public String customIdGenerator(Role role)
    {
        String prefix = "";

        if (role instanceof Manager)
            prefix = "mgr";
        else if (role instanceof Volunteer)
            prefix = "vol";
        else
            throw new HibernateException("Unsupported entity type: " + role.getClass().getSimpleName());

        int uniqueNumber = getUniqueNumber(); // Retrieve a unique number based on the current timestamp
        String id = prefix + String.format("%04d", uniqueNumber);
        return id;
    }

    private int getUniqueNumber() {
        long timestamp = System.currentTimeMillis();
        return (int) (timestamp % 10000);
    }
}
