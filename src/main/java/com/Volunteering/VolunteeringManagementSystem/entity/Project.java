package com.Volunteering.VolunteeringManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "tbl_projects")
public class Project {

    @Id
    private String projectId;

    private String projectName;
    private String description;

    @ManyToOne
    @JoinColumn(name = "program_id")
    private Program program;

    private String location;
    private String duration;
    private List<String> skillsRequired;

    @Enumerated(EnumType.STRING)
    private ProjectStatus projectStatus;

//    @ManyToOne
//    @JoinColumn(name= "city_id")
//    private City city;

    //Relationship
//    @ManyToOne
//    @JoinColumn(name = "managerId")
//    private Manager manager;

    // Relationship
    @ManyToMany(mappedBy = "assignedProjects")
    private Set<Volunteer> volunteers = new HashSet<>();

    public Project() {}

    public Project(String projectName, String description, String location, String duration, List<String> skillsRequired, ProjectStatus projectStatus, Set<Volunteer> volunteers) {
        this.projectId = generateId();
        this.projectName = projectName;
        this.description = description;
        this.location = location;
        this.duration = duration;
        this.skillsRequired = skillsRequired;
        this.projectStatus = projectStatus;
//        this.city = city;
//        this.manager = manager;
        this.volunteers = volunteers;
    }


// METHODS

    // For retrieving all Projects from DB
    public List<Project> listAllProjects()
    {
        /////////

        List<Project> projectsList = new ArrayList<>();
        return projectsList;
    }

    // For searching Projects by NAME from DB
    public String searchProjectsByName(String projectName)
    {
        /////////

        return "Projects By NAME List";
    }


    // For searching Projects by PROGRAM NAME from DB
    public String searchProjectsByProgramName(String programName)
    {
        /////////

        return "Projects By PROGRAM NAME List";
    }


////////////////////
    // Generating unique ID for the Project
    // which begins with "proj" followed by 4 numbers
public String generateId() {
        int uniqueNumber = getUniqueNumber(); // Retrieve a unique number based on the current timestamp

        return "proj" + String.format("%04d", uniqueNumber);
    }

    // This method generates a unique number based on the current timestamp
    private int getUniqueNumber() {
        long timestamp = System.currentTimeMillis();
        return (int) (timestamp % 10000);
    }
}
