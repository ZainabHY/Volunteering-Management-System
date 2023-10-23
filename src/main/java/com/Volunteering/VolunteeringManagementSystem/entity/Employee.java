package com.Volunteering.VolunteeringManagementSystem.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

public interface Employee {

    // Methods

    // Validate credentials to ensure that user is authorized to access the system
    public void validateCredentials();

    // Changing the password for the users if they ask for
    public String changePassword();

    // Create an account in the system
    public void signUp(Role role);

    // Login to the system and use its functionalities
    public void login(String username, String password);

}
