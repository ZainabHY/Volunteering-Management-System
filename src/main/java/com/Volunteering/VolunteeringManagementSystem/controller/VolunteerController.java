package com.Volunteering.VolunteeringManagementSystem.controller;

import com.Volunteering.VolunteeringManagementSystem.entity.Volunteer;
import com.Volunteering.VolunteeringManagementSystem.service.implementations.VolunteerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/volunteers")
public class VolunteerController {
    // 1. Autowired the Service Implementation
    @Autowired
    private VolunteerServiceImpl volunteerService;

    // 2. Create Request Methods (GET, POST, DELETE, PUT, PATCH)

    @GetMapping("/")
    public String volunteerHome()
    {
        return "Welcome | This is the Volunteers Home";
    }

    // Get all volunteers --> GET Request
    @GetMapping("/getAllVolunteers")
    public List<Volunteer> getAllVolunteers(){
        return volunteerService.getAllVolunteers();
    }


    // Get volunteer by VOLUNTEER ID --> Using PATH VARIABLE
    @GetMapping("/getVolunteerById/{volunteerId}")
    public Optional<Volunteer> getVolunteerId(@PathVariable String volunteerId)
    {
        return volunteerService.getVolunteerById(volunteerId);
    }

    // Get volunteer by AVAILABILITY
    @GetMapping("/getVolunteerByAvailability/{availability}")
    public Optional<Volunteer> getVolunteerByAvailability(@PathVariable String availability)
    {
        return volunteerService.getVolunteerByAvailability(availability);
    }


    // Adding a new Volunteer --> POST Request
    @PostMapping("/addVolunteer")
    public ResponseEntity<String> addVolunteer(@RequestBody Volunteer volunteer)
    {
        try{
            volunteerService.addVolunteer(volunteer);
            String msg = "Provided volunteer added successfully";
            return ResponseEntity.status(HttpStatus.OK).body(msg);
        }
        catch (Exception e)
        {
            String errMsg = "Volunteer provided not added \n\n" + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errMsg);
        }
    }

    // Adding multiple new Volunteers --> POST Request
    @PostMapping("/addMultipleVolunteers")
    public ResponseEntity<String> addMultipleVolunteers(@RequestBody List<Volunteer> volunteer)
    {
        try{
            volunteerService.addMultipleVolunteer(volunteer);
            String msg = "All provided Volunteers added successfully";
            return ResponseEntity.status(HttpStatus.OK).body(msg);
        }
        catch (Exception e)
        {
            String errMsg = "Volunteers provided not added successfully \n\n" + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errMsg);
        }
    }

    // Delete Volunteer
    @DeleteMapping("/deleteVolunteer/{volunteerId}")
    public String deleteVolunteer(@PathVariable String volunteerId)
    {
        return volunteerService.deleteVolunteer(volunteerId);
    }

    // Update Volunteer --> using Put
    @PutMapping("/updateVolunteer/{volunteerId}")
    public String updateVolunteer(@PathVariable String volunteerId, @RequestBody Volunteer volunteer)
    {
        return volunteerService.updateVolunteer(volunteerId, volunteer);
    }

    // Update Volunteer --> using Patch
    // --> Just updating the needed properties
    @PatchMapping("/partialUpdateVolunteer/{volunteerId}")
    @ResponseStatus(value = HttpStatus.OK)
    public String  partialUpdateVolunteer(@PathVariable String volunteerId, @RequestBody Map<String, Object> updatedVolunteer)
    {
        return volunteerService.partialUpdateVolunteer(volunteerId, updatedVolunteer);
    }
}
