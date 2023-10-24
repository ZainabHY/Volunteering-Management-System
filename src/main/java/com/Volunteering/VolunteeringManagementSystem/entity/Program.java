package com.Volunteering.VolunteeringManagementSystem.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_programs")
@Getter
@Setter
public class Program {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String programId;

    private String programName;
    private String description;
    private String startDate;
    private String endDate;
    //
    //Relationship
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Manager manager;

//    @ManyToOne
//    @JoinColumn(name = "managerId")
//    private Manager manager;

//        @Id
//        @Column(name = "program_id", columnDefinition = "VARCHAR(50)")
//
//        private String programId;
//
//        @Column(name = "program_name", columnDefinition = "VARCHAR(255)")
//        private String programName;
//
//        @Column(name = "description", columnDefinition = "TEXT")
//        private String description;
//
//        @Column(name = "start_date", columnDefinition = "DATE")
//        private String startDate;
//
//        @Column(name = "end_date", columnDefinition = "DATE")
//        private String endDate;

    // Relationship
//        @ManyToOne(fetch = FetchType.LAZY)
//        @JoinColumn(name = "roleId", columnDefinition = "VARCHAR(255)")
//        private Manager manager;

//        @JdbcTypeCode(SqlTypes.JSON)
//        @ManyToOne(fetch = FetchType.LAZY)
//        @JoinColumn(name = "role_id")
//        private Manager manager;

    public Program() {}

    public Program(String programName, String description, String startDate, String endDate) {
        this.programId = generateId();
        this.programName = programName;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // METHODS

    // For retrieving all Programs from DB
//    public List<Program> listAllPrograms()
//    {
//        /////////
//
//        List<Program> programsList = new ArrayList<>();
//        return programsList;
//    }
//
//    // For searching Programs by NAME from DB
//    public String searchProgramsByName(String programName)
//    {
//        /////////
//
//        return "Programs By NAME List";
//    }
//
//    // For searching Programs by START DATE from DB
//    public String searchProgramsByStartDate(String startDate)
//    {
//        /////////
//
//        return "Programs By START DATE List";
//    }
//
//
////////////////
//
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