package com.Volunteering.VolunteeringManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.HibernateException;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

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
//    public abstract boolean validateCredentials(String username, String password);
//
//    public abstract boolean changePassword(String currentPassword, String newPassword);


//    private Map<String, User> users; // In-memory storage for user data
//
//    public UserService() {
//        users = new HashMap<>();
//    }
//
//    public void signUp(String roleName, String username, String password, String email, String phoneNumber) {
//        // Check if the username is already taken
//        if (users.containsKey(username)) {
//            throw new IllegalArgumentException("Username already exists. Please choose a different username.");
//        }
//
//        // Create a new User object with the provided information
//        ContactInfo contactInfo = new ContactInfo(email, phoneNumber);
//        User newUser = new User(roleName, username, password, contactInfo);
//
//        // Store the User object in the users map with the username as the key
//        users.put(username, newUser);
//        System.out.println("User signed up successfully.");
//    }


//    public boolean signUp(Role role)
//    {
//
//    }
//    public boolean login(String username, String password)
//    {
//
//    }

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

    private List<GrantedAuthority> getRoles(Role role) {
        String roleName = role.getRoleName();
        // Convert the roleName to a GrantedAuthority object
        // For example:
        return Collections.singletonList(new SimpleGrantedAuthority(roleName));
    }

//    public abstract boolean validateCredentials(String username, String password);
//
//    public abstract boolean changePassword(String currentPassword, String newPassword);
}
