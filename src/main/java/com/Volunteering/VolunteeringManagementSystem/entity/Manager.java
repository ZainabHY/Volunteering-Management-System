package com.Volunteering.VolunteeringManagementSystem.entity;

import com.Volunteering.VolunteeringManagementSystem.repository.ManagerRepository;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

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


//    @Autowired
//    ManagerRepository managerRepository;
//
//    @Override
//    public boolean signUp(Role role) {
//        try
//        {
//            managerRepository.save(this); // this refers to the current instance
//            System.out.println("Manager Registration: " + getUsername());
//            return true;
//        }
//        catch (Exception e)
//        {
//            System.err.println("Manager Registration Failed" + e.getMessage());
//            return false;
//        }
//    }
//
//    // Login method for Manager --> With error handling (try-catch)
//    @Override
//    public boolean login(String username, String password) {
//        try
//        {
//            if(getUsername().equals(username) && getPassword().equals(password))
//            {
//                System.out.println("Manager login successfully!");
//                return true;
//            }
//            System.out.println("Manager login failed, username or password is incorrect");
//            return false;
//        }
//        catch (Exception e)
//        {
//            System.err.println("Manager login failed" + e.getMessage());
//            return false;
//        }
//    }
//
//
//    //Validating credentials for manager
//    @Override
//    public boolean validateCredentials(String username, String password) {
//        try {
//            // Check if the username and password are equal to the ones saved in DB
//            if (getUsername().equals(username) && getPassword().equals(password)) {
//                System.out.println("Manager credentials are valid");
//                return true;
//            }
//            System.out.println("Manager credentials are invalid");
//            return false;
//        } catch (Exception e) {
//            System.err.println("Manager credentials validation failed Due: " + e.getMessage());
//            return false;
//        }
//    }
//
//    //Changing password for manager
//    @Override
//    public boolean changePassword(String currentPassword, String newPassword) {
//        try {
//            // Check if the password are equal to the one saved in DB
//            if (getPassword().equals(currentPassword)) {
//                setPassword(newPassword);
//                System.out.println("Manager password changed successfully.");
//                return true;
//            }
//            System.out.println("Manager password change failed. Current password is incorrect");
//            return false;
//        } catch (Exception e) {
//            System.err.println("Manager password change failed Due: " + e.getMessage());
//            return false;
//        }
//    }



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