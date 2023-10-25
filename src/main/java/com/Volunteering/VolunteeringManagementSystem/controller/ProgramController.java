package com.Volunteering.VolunteeringManagementSystem.controller;

import com.Volunteering.VolunteeringManagementSystem.entity.Program;
import com.Volunteering.VolunteeringManagementSystem.service.implementations.ProgramServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/programs")
public class ProgramController {

    // 1. Autowired the Service Implementation
    @Autowired
    private ProgramServiceImpl programService;

    // 2. Create Request Methods (GET, POST, DELETE, PUT, PATCH)

    @GetMapping("/")
    public String programHome()
    {
        return "Welcome | This is the Programs Home";
    }

    // Get all programs --> GET Request
    @GetMapping("/getAllPrograms")
    public List<Program> getAllPrograms(){
        return programService.getAllPrograms();
    }


    // Get program by PROGRAM ID --> Using PATH VARIABLE
    @GetMapping("/getProgramById/{programId}")
    public Optional<Program> getProgramById(@PathVariable String programId)
    {
        return programService.getProgramById(programId);
    }

    // Get program by PROGRAM NAME --> Using PATH VARIABLE
    @GetMapping("/getProgramByName/{programName}")
    public Optional<Program> getProgramByName(@PathVariable String programName)
    {
        return programService.getProgramByName(programName);
    }


    // Adding a new Program --> POST Request
    @PostMapping("/addProgram")
    public String addProgram(@RequestBody Program program)
    {
        return programService.addProgram(program);
    }

    // Adding multiple new Programs --> POST Request
    @PostMapping("/addMultiplePrograms")
    public String addMultiplePrograms(@RequestBody List<Program> programs)
    {
            return programService.addMultiplePrograms(programs);
    }

    // Delete Program
    @DeleteMapping("/deleteProgram/{programId}")
    public String deleteProgram(@PathVariable String programId)
    {
        return programService.deleteProgram(programId);
    }

    // Update Program --> using Put
    @PutMapping("/updatePrograms/{programId}")
    public String updatePrograms(@PathVariable String programId, @RequestBody Program program)
    {
        return programService.updateProgram(programId, program);
    }

    // Update Program --> using Patch
    // --> Just updating the needed properties
    @PatchMapping("/partialUpdateProgram/{programId}")
    @ResponseStatus(value = HttpStatus.OK)
    public String  partialUpdateProgram(@PathVariable String programId, @RequestBody Map<String, Object> updatedProgram)
    {
        return programService.partialUpdateProgram(programId, updatedProgram);
    }

}
