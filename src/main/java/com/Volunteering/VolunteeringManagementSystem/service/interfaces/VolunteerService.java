package com.Volunteering.VolunteeringManagementSystem.service.interfaces;

import com.Volunteering.VolunteeringManagementSystem.entity.Volunteer;

import java.util.List;
import java.util.Optional;

public interface VolunteerService {

    // Get all volunteers --> GET Request
    public List<Volunteer> getAllVolunteers();

    // Get volunteer by VOLUNTEER ID --> Using PATH VARIABLE
//    public Optional<Volunteer> getVolunteerById(String volunteerId);

    // 2. Get volunteer by VOLUNTEER ID --> Using Query Parameter
    public Optional<Volunteer> getVolunteerById(String volunteerId);

    // Adding a new Volunteer --> POST Request
    public Volunteer addVolunteer(Volunteer volunteer);

    // Adding multiple new Volunteers --> POST Request
    public List<Volunteer> addMultipleVolunteer(List<Volunteer> volunteers);

    // Delete Volunteer
    public String deleteVolunteer(String volunteerId);

    // Update Volunteer
    public String updateVolunteer(String volunteerId, Volunteer volunteer);
}
