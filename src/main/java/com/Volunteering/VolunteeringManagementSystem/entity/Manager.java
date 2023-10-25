package com.Volunteering.VolunteeringManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "tbl_managers")
@PrimaryKeyJoinColumn(name = "manager_id") // setting the id name as manager_id instead of role_id
@AttributeOverride(name = "roleId", column = @Column(name = "manager_id"))
public class Manager extends Role{



    //The programs that the manager supervised
    @OneToMany(mappedBy = "manager",fetch = FetchType.EAGER)
    private Set<Program> supervisedPrograms;

//    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Program> supervisedPrograms;

    public Manager(){}

    public Manager(String roleName, String username, String password, ContactInfo contactInfo) {
        super(roleName, username, password, contactInfo);
    }

    @Override
    public boolean signUp(Role role) {
        try
        {
            System.out.println("Manager Registration: " + getUsername());
            return true;
        }
        catch (Exception e)
        {
            System.err.println("Manager Registration Failed" + e.getMessage());
            return false;
        }
    }

    // Login method for Manager --> With error handling (try-catch)
    @Override
    public boolean login(String username, String password) {
        try
        {
            if(getUsername().equals(username) && getPassword().equals(password))
            {
                System.out.println("Manager login successfully!");
                return true;
            }
            System.out.println("Manager login failed");
            return false;
        }
        catch (Exception e)
        {
            System.err.println("Manager login failed" + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean validateCredentials() {
        return false;
    }

    @Override
    public boolean changePassword() {
        return false;
    }



// METHODS

    // Retrieve a list of all volunteers from the DB
//    public List<Volunteer> viewAllVolunteers()
//    {
//
//        List<Volunteer> volunteersList = new ArrayList<>();
//        return volunteersList;
//    }
//
//    // For Programs
//    // Add Program to the DB
//    public String addProgram(Program program)
//    {
//
//        return "Program " + program.getProgramName() + " added successfully";
//    }
//
//    // Remove Program from the DB
//    public String removeProgram(String programId)
//    {
//
//        return "Program " + "program.getProgramName()" + " deleted successfully";
//    }
//
//    // Update Program in the DB
//    public String updateProgram(String programId, Program program)
//    {
//
//        return "Program with ID: " + programId + " updated successfully";
//    }
//
//    // For Projects
//    // Add Project to the DB
//    public String addProject(Project project)
//    {
//
//        return "Project " + project.getProjectName() + " added successfully";
//    }
//
//    // Remove Project from the DB
//    public String removeProject(String projectId)
//    {
//
//        return "Project " + "project.getProjectName()" + " deleted successfully";
//    }
//
//    // Update Project in the DB
//    public String updateProject(String projectId, Project project)
//    {
//
//        return "Project with ID: " + projectId + " updated successfully";
//    }
}