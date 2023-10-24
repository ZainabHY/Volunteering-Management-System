package com.Volunteering.VolunteeringManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Entity
@Data
@Table(name = "tbl_volunteers")
public class Volunteer extends Role{



    private String skills;

    @Enumerated
    private Availability availability;

    @ManyToMany
    @JoinTable(
            name = "volunteer_project",
            joinColumns = @JoinColumn(name = "volunteer_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private Set<Project> assignedProjects = new HashSet<>();

    private int volunteeringHours;

    public Volunteer(){}
    public Volunteer(String roleName, String username, String password, ContactInfo contactInfo, String skills, Availability availability, Set<Project> assignedProjects, int volunteeringHours) {
        super(roleName, username, password, contactInfo);

        this.skills = skills;
        this.availability = availability;
        this.assignedProjects = assignedProjects;
        this.volunteeringHours = volunteeringHours;
    }

    // METHODS
//    public String registerInProgram(Program program)
//    {
//
//        return "";
//    }

    public String updateInfo()
    {

        return "";
    }


////////////////
     // Generating unique ID for the Volunteer
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
