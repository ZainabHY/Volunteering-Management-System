package com.Volunteering.VolunteeringManagementSystem.controller;

import com.Volunteering.VolunteeringManagementSystem.CustomResponse;
import com.Volunteering.VolunteeringManagementSystem.entity.Volunteer;
import com.Volunteering.VolunteeringManagementSystem.service.implementations.VolunteerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/volunteers")
public class VolunteerController {
    // 1. Autowired the Service Implementation
    @Autowired
    private VolunteerServiceImpl volunteerService;

    private static final Logger logger = LoggerFactory.getLogger(VolunteerController.class);

    // 2. Create Request Methods (GET, POST, DELETE, PUT, PATCH)

    @GetMapping("/")
    public String volunteerHome()
    {
        return "Welcome | This is the Volunteers Home";
    }

    // Get all volunteers --> GET Request
//    @GetMapping("/getAllVolunteers")
//    public List<Volunteer> getAllVolunteers(){
////        logger.info("Received GET request for all volunteers.");
//        return volunteerService.getAllVolunteers();
//    }

    @GetMapping("/getAllVolunteers")
    public ResponseEntity<CustomResponse> getAllVolunteers(){

        try{
            List<Volunteer> volunteers = volunteerService.getAllVolunteers();
            String msg = "\n--- These are all volunteers ---";

            CustomResponse response = new CustomResponse(msg, volunteers);
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
        }
        catch (Exception e)
        {
            String errmsg = "--- Sorry, there is no volunteers data ---\n\n";
            CustomResponse response = new CustomResponse(errmsg, null);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON).body(response);
        }
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
            String msg = "Provided volunteer: " + volunteer.getRoleName() + " is added successfully";
            return ResponseEntity.status(HttpStatus.OK).body(msg);
        }
        catch (Exception e)
        {
            String errMsg = "Provided volunteer : " + volunteer.getRoleName() + " is not added \n\n" + e.getMessage();
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
