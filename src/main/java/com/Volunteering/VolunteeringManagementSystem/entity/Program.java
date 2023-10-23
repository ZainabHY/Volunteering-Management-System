package com.Volunteering.VolunteeringManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "tbl_programs")
public class Program {

    @Id
    private String programId;

    private String programName;
    private String description;
    private String startDate;
    private String endDate;

    //Relationship
    @ManyToOne
    @JoinColumn(name = "managerId")
    private Manager manager;

    public Program() {}

    public Program(String programName, String description, String startDate, String endDate, Manager manager) {
        this.programId = generateId();
        this.programName = programName;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.manager = manager;
    }

 // METHODS

    // For retrieving all Programs from DB
    public List<Program> listAllPrograms()
    {
        /////////

        List<Program> programsList = new ArrayList<>();
        return programsList;
    }

    // For searching Programs by NAME from DB
    public String searchProgramsByName(String programName)
    {
        /////////

        return "Programs By NAME List";
    }

    // For searching Programs by START DATE from DB
    public String searchProgramsByStartDate(String startDate)
    {
        /////////

        return "Programs By START DATE List";
    }


//////////////

    // Generating unique ID for the Program
    // which begins with "prog" followed by 4 numbers
    private String generateId() {
        int uniqueNumber = getUniqueNumber(); // Retrieve a unique number based on the current timestamp

        return "prog" + String.format("%04d", uniqueNumber);
    }

    // This method generates a unique number based on the current timestamp
    private int getUniqueNumber() {
        long timestamp = System.currentTimeMillis();
        return (int) (timestamp % 10000);
    }


}
