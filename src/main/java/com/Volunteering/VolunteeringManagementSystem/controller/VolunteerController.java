package com.Volunteering.VolunteeringManagementSystem.controller;

import com.Volunteering.VolunteeringManagementSystem.entity.Volunteer;
import com.Volunteering.VolunteeringManagementSystem.service.implementations.VolunteerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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


    // Adding a new Volunteer --> POST Request
    @PostMapping("/addVolunteer")
    public Volunteer addVolunteer(@RequestBody Volunteer volunteer)
    {
        return volunteerService.addVolunteer(volunteer);
    }

    // Adding multiple new Volunteers --> POST Request
//    public List<Volunteer> addMultipleVolunteers(List<Volunteer> volunteer);

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
    public String  partialUpdateVolunteer(@PathVariable String volunteerId, @RequestBody HashMap<String, Object> updatedVolunteer)
    {
        return volunteerService.partialUpdateVolunteer(volunteerId, updatedVolunteer);
    }
}
