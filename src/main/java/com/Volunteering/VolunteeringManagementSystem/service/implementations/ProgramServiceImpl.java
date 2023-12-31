package com.Volunteering.VolunteeringManagementSystem.service.implementations;

import com.Volunteering.VolunteeringManagementSystem.entity.*;
import com.Volunteering.VolunteeringManagementSystem.repository.ManagerRepository;
import com.Volunteering.VolunteeringManagementSystem.repository.ProgramRepository;
import com.Volunteering.VolunteeringManagementSystem.service.interfaces.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Service
public class ProgramServiceImpl implements ProgramService {

    // 1. Autowired the Repository
    @Autowired
    private ProgramRepository programRepository;
    @Autowired
    private ManagerRepository managerRepository;


    // 2. Create the implementations of the methods in Program Service Interface


        @Override
        public List<Program> getAllPrograms() {
            return programRepository.findAll();
        }

        @Override
        public Optional<Program> getProgramById(String programId) {
            return programRepository.findById(programId);
        }

        @Override
        public Optional<Program> getProgramByName(String programName) {
            return Optional.ofNullable(programRepository.findByProgramName(programName));
        }


//    @Override
//    public List<Program> getAllPrograms() {
//        return programRepository.findAll();
//    }
//
//    @Override
//    public Optional<Program> getProgramById(String programId) {
//        return programRepository.findById(programId);
//    }
//
//    @Override
//    public Optional<Program> getProgramByName(String programName) {
//        return programRepository.findByProgramName(programName);
//    }

    @Override
    public String addProgram(Program program) {
        String msg = "";
        // Set ID for program
        String programId = program.generateId();
        program.setProgramId(programId);

        //Save the program with the associated manager
        // By retrieving the manager id and look if it is exists
        Manager manager = managerRepository.findByRoleId(program.getManager().getRoleId());
        if (manager != null)
        {
            program.setManager(manager);
            programRepository.save(program);
            msg = "Program " + program.getProgramName() + " added successfully!";
        }
        else
            msg = "Sorry, manager with ID " + program.getManager().getRoleId() + " not found";

        return msg;
    }

    @Override
    public String addMultiplePrograms(List<Program> programs) {
        String msg = "";

        // Set IDs for programs
        for(Program program: programs)
        {
            String programId = program.generateId();
            program.setProgramId(programId);

            //Save the program with the associated manager
            // By retrieving the manager id and look if it is exists
            Manager manager = managerRepository.findByRoleId(program.getManager().getRoleId());
            if (manager != null)
            {
                program.setManager(manager);
                programRepository.save(program);
                msg += "\nProgram " + program.getProgramName() + " added successfully!";
            }
            else
                msg += "\nSorry, manager with ID " + program.getManager().getRoleId() + " not found";
        }
        return msg;
    }

    @Override
    public String deleteProgram(String programId) {
        Optional<Program> foundProgram = programRepository.findById(programId);

        // 1. Checking if program with ID programId is present int the DB
        if(foundProgram.isPresent())
        {
            // 2. Delete the program from DB
            programRepository.deleteById(programId);
            return "Program with ID: " + programId + " deleted successfully";
        }
        else
            return "Sorry, program with ID: " + programId + " not found";
    }

    // Update entire a program data
    @Override
    public String updateProgram(String programId, Program program) {
        Optional<Program> foundProgram = programRepository.findById(programId);

        // 1. Checking if program with ID programId is present in DB
        if (foundProgram.isPresent()) {
            Program existingProgram = foundProgram.get();

            // 2. Set the new values
            existingProgram.setProgramName(program.getProgramName());
            existingProgram.setDescription(program.getDescription());
            existingProgram.setStartDate(program.getStartDate());
            existingProgram.setEndDate(program.getEndDate());
            existingProgram.setManager(program.getManager());

            // 3. Save the updated program to the database
            programRepository.save(existingProgram);
            return "Program with Program ID: " + programId + " updated successfully";
        } else {
            return "Sorry, program with Program ID: " + programId + " not found";
        }
    }

    // Partial update of a program data
    @Override
    public String partialUpdateProgram(String programId, Map<String, Object> updatedProgram) {
        Optional<Program> foundProgram = programRepository.findById(programId);

        // Checking if program with ID programId is present in the DB
        if (foundProgram.isPresent()) {
            Program existingProgram = foundProgram.get();

            for (Map.Entry<String, Object> entry : updatedProgram.entrySet()) {
                String fieldName = entry.getKey();
                Object fieldValue = entry.getValue();

                // Update the specified field if it exists and the value is not null
                switch (fieldName) {
                    case "programName":
                        if (fieldValue != null) {
                            existingProgram.setProgramName((String) fieldValue);
                        }
                        break;

                    case "description":
                        if (fieldValue != null) {
                            existingProgram.setDescription((String) fieldValue);
                        }
                        break;

                    case "startDate":
                        if (fieldValue != null) {
                            existingProgram.setStartDate((String) fieldValue);
                        }
                        break;

                    case "endDate":
                        if (fieldValue != null) {
                            existingProgram.setEndDate((String) fieldValue);
                        }
                        break;

                    case "manager":
                        if (fieldValue != null) {
//                            Manager manager = managerRepository.findById(fieldValue);
                            existingProgram.setManager((Manager) fieldValue);
                        }
                        break;
                }
            }

            // Save the updated program to the database
            programRepository.save(existingProgram);
            return "Volunteer with Volunteer ID: " + programId + " updated successfully";
        } else {
            return "Sorry, program with Volunteer ID: " + programId + " not found";
        }
    }
}
