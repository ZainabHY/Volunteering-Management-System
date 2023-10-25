package com.Volunteering.VolunteeringManagementSystem.service.interfaces;

import com.Volunteering.VolunteeringManagementSystem.entity.Program;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProgramService {

    // Get all Programs --> GET Request
    public List<Program> getAllPrograms();

    // Get Program by PROGRAM ID --> Using PATH VARIABLE
//    public Optional<Program> getProgramById(String programId);

    // Get program by PROGRAM ID --> Using Query Parameter
    public Optional<Program> getProgramById(String programId);

    // Get program by PROGRAM NAME
    public Optional<Program> getProgramByName(String programId);

    // Adding a new Program --> POST Request
    public String addProgram(Program program);

    // Adding multiple new Programs --> POST Request
    public String addMultiplePrograms(List<Program> programs);

    // Delete Program
    public String deleteProgram(String programId);

    // Update Program --> PUT
    public String updateProgram(String programId, Program program);

    // Partial Update Program --> PATCH
    // Using MAP instead of HashMap for better type safety and flexibility
    // and to preserve types of the values
    public String partialUpdateProgram(String programId, Map<String, Object> updatedProgram);

}
