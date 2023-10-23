package com.Volunteering.VolunteeringManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "tbl_managers")
public class Manager extends Role{

    @Id
    private String managerId;

    // The programs that the manager supervised
    private List<Program> supervisedPrograms;

    public Manager(){}

    public Manager(String roleName, String username, String password, ContactInfo contactInfo, List<Program> supervisedPrograms) {
        super(roleName, username, password, contactInfo);
        this.managerId = generateId();
        this.supervisedPrograms = supervisedPrograms;
    }

    // METHODS



    ////////////////
    // Generating unique ID for the Manager
    // which begins with "mgr" followed by 4 numbers
    private String generateId() {
        int uniqueNumber = getUniqueNumber(); // Retrieve a unique number based on the current timestamp

        return "mgr" + String.format("%04d", uniqueNumber);
    }

    // This method generates a unique number based on the current timestamp
    private int getUniqueNumber() {
        long timestamp = System.currentTimeMillis();
        return (int) (timestamp % 10000);
    }
}
