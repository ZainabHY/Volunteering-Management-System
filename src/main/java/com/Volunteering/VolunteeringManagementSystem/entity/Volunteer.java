package com.Volunteering.VolunteeringManagementSystem.entity;

import com.Volunteering.VolunteeringManagementSystem.repository.VolunteerRepository;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Entity
@Data
@Table(name = "tbl_volunteers")
@PrimaryKeyJoinColumn(name = "volunteer_id") // setting the id name as volunteer_id instead of role_id
@AttributeOverride(name = "roleId", column = @Column(name = "volunteer_id"))
public class Volunteer extends Role{

    @Enumerated(EnumType.STRING)
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
    public Volunteer(String roleName, String username, String password, ContactInfo contactInfo, Availability availability, Set<Project> assignedProjects, int volunteeringHours) {
        super(roleName, username, password, contactInfo);

//        this.skills = skills;
        this.availability = availability;
        this.assignedProjects = assignedProjects;
        this.volunteeringHours = volunteeringHours;
    }

    @Autowired
    VolunteerRepository volunteerRepository;

    public boolean signUp(Role role) {
        try
        {
            volunteerRepository.save(this); // this refer to the current instance
            System.out.println("Volunteer Registration: " + getUsername());
            return true;
        }
        catch (Exception e)
        {
            System.err.println("Volunteer Registration Failed" + e.getMessage());
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
                System.out.println("Volunteer login successfully!");
                return true;
            }
            System.out.println("Volunteer login failed, username or password is incorrect");
            return false;
        }
        catch (Exception e)
        {
            System.err.println("Volunteer login failed" + e.getMessage());
            return false;
        }
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

}
