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
