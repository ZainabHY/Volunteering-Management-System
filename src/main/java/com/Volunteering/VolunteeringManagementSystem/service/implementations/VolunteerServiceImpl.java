package com.Volunteering.VolunteeringManagementSystem.service.implementations;

import com.Volunteering.VolunteeringManagementSystem.entity.Volunteer;
import com.Volunteering.VolunteeringManagementSystem.repository.VolunteerRepository;
import com.Volunteering.VolunteeringManagementSystem.service.interfaces.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VolunteerServiceImpl implements VolunteerService {

    @Autowired
    private VolunteerRepository volunteerRepository;

    @Override
    public List<Volunteer> getAllVolunteers() {
        return volunteerRepository.findAll();
    }

    @Override
    public Optional<Volunteer> getVolunteerById(String volunteerId) {
        return volunteerRepository.findById(volunteerId);
    }

    @Override
    public Volunteer addVolunteer(Volunteer volunteer) {
        volunteer.setRoleId(volunteer.customIdGenerator(volunteer));
        return volunteerRepository.save(volunteer);
    }

    @Override
    public List<Volunteer> addMultipleVolunteer(List<Volunteer> volunteers) {
        return volunteerRepository.saveAll(volunteers);
    }

    @Override
    public String deleteVolunteer(String volunteerId) {

        Optional<Volunteer> foundVolunteer = volunteerRepository.findById(volunteerId);

        // 1. Checking if volunteerId is present int the DB
        if(foundVolunteer.isPresent())
        {
            // 2. Delete the volunteer from DB
            volunteerRepository.deleteById(volunteerId);
            return "Volunteer with ID: " + volunteerId + " deleted successfully";
        }
        else
            return "Volunteer with ID: " + volunteerId + " not found";
    }

    @Override
    public String updateVolunteer(String volunteerId, Volunteer volunteer) {
        return null;
    }
}
