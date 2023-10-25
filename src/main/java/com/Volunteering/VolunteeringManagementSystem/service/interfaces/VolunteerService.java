package com.Volunteering.VolunteeringManagementSystem.service.interfaces;

import com.Volunteering.VolunteeringManagementSystem.entity.Volunteer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface VolunteerService {

    // Get all volunteers --> GET Request
    public List<Volunteer> getAllVolunteers();

    // Get volunteer by VOLUNTEER ID --> Using PATH VARIABLE
//    public Optional<Volunteer> getVolunteerById(String volunteerId);

    // 2. Get volunteer by VOLUNTEER ID --> Using Query Parameter
    public Optional<Volunteer> getVolunteerById(String volunteerId);

    public Optional<Volunteer> getVolunteerByAvailability(String availability);

    // Adding a new Volunteer --> POST Request
    public Volunteer addVolunteer(Volunteer volunteer);

    // Adding multiple new Volunteers --> POST Request
    public List<Volunteer> addMultipleVolunteer(List<Volunteer> volunteers);

    // Delete Volunteer
    public String deleteVolunteer(String volunteerId);

    // Update Volunteer --> PUT
    public String updateVolunteer(String volunteerId, Volunteer volunteer);

    // Partial Update Volunteer --> PATCH
    // Using MAP instead of HashMap for better type safety and flexibility
    // and to preserve types of the values
    public String partialUpdateVolunteer(String volunteerId, Map<String, Object> updatedVolunteer);


    // as Sign Up
    public boolean registerVolunteer(Volunteer volunteer);
}
