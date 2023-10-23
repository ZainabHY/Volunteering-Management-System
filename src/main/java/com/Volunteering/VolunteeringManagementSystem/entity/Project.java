package com.Volunteering.VolunteeringManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "tbl_projects")
public class Project {

    @Id
    private String projectId;

    private String projectName;
    private String description;
    private Program program;

    private String location;
    private String duration;
    private List<String> skillsRequired;
    private ProjectStatus projectStatus;
    private City city;

    //Relationship
    @ManyToOne
    @JoinColumn(name = "managerId")
    private Manager manager;

    public Project() {}



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
    private String generateId() {
        int uniqueNumber = getUniqueNumber(); // Retrieve a unique number based on the current timestamp

        return "proj" + String.format("%04d", uniqueNumber);
    }

    // This method generates a unique number based on the current timestamp
    private int getUniqueNumber() {
        long timestamp = System.currentTimeMillis();
        return (int) (timestamp % 10000);
    }
}
