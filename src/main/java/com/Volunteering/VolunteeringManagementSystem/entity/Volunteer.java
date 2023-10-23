package com.Volunteering.VolunteeringManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Random;

@Entity
@Data
@Table(name = "tbl_volunteer")
public class Volunteer extends Role{

    @Id
    private String volunteerId;

    private String skills;

    @Enumerated
    private Availability availability;

    private List<Project> assignedProjects;

    private int volunteeringHours;


// METHODS
    public String registerInProgram(Program program)
    {

        return "";
    }

    public String updateInfo()
    {

        return "";
    }

     // Generating unique ID for the volunteer
     // which begins with "vol" followed by 4 numbers
    private String generateId() {
        int uniqueNumber = getUniqueNumber(); // Retrieve a unique number based on the current timestamp

        return "vol" + String.format("%04d", uniqueNumber);
    }

    // This method generates a unique number based on the current timestamp
    private int getUniqueNumber() {
        long timestamp = System.currentTimeMillis();
        return (int) (timestamp % 10000);
    }

}
