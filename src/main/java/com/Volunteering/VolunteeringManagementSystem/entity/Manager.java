package com.Volunteering.VolunteeringManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
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

    // Retrieve a list of all volunteers from the DB
    public List<Volunteer> viewAllVolunteers()
    {

        List<Volunteer> volunteersList = new ArrayList<>();
        return volunteersList;
    }

    // For Programs
    // Add Program to the DB
    public String addProgram(Program program)
    {

        return "Program " + program.getProgramName() + " added successfully";
    }

    // Remove Program from the DB
    public String removeProgram(String programId)
    {

        return "Program " + "program.getProgramName()" + " deleted successfully";
    }

    // Update Program in the DB
    public String updateProgram(String programId, Program program)
    {

        return "Program with ID: " + programId + " updated successfully";
    }

    // For Projects
    // Add Project to the DB
    public String addProject(Project project)
    {

        return "Project " + project.getProjectName() + " added successfully";
    }

    // Remove Project from the DB
    public String removeProject(String projectId)
    {

        return "Project " + "project.getProjectName()" + " deleted successfully";
    }

    // Update Project in the DB
    public String updateProject(String projectId, Project project)
    {

        return "Project with ID: " + projectId + " updated successfully";
    }


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
