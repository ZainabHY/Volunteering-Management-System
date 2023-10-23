package com.Volunteering.VolunteeringManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "tbl_cities")
public class City {

    @Id
    private String cityId;

    private String cityName;

    // Many projects for each city
    @OneToMany(mappedBy = "city")
    private Set<Project> projects;


    // For retrieving all Projects Along with CITY from DB
    public List<Project> listAllProjectsAlongWithCity(String city)
    {
        /////////

        List<Project> projectsList = new ArrayList<>();
        return projectsList;
    }


//    // For searching Projects by CITY from DB
//    public String searchProjectsByCity(String city)
//    {
//        /////////
//
//        return "Projects By CITY List";
//    }


    ////////////////////
    // Generating unique ID for the City
    // which begins with "city" followed by 4 numbers
    private String generateId() {
        int uniqueNumber = getUniqueNumber(); // Retrieve a unique number based on the current timestamp

        return "city" + String.format("%04d", uniqueNumber);
    }

    // This method generates a unique number based on the current timestamp
    private int getUniqueNumber() {
        long timestamp = System.currentTimeMillis();
        return (int) (timestamp % 10000);
    }
}
