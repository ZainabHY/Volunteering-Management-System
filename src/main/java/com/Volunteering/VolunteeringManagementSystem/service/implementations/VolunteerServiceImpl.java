package com.Volunteering.VolunteeringManagementSystem.service.implementations;

import com.Volunteering.VolunteeringManagementSystem.entity.*;
import com.Volunteering.VolunteeringManagementSystem.repository.VolunteerRepository;
import com.Volunteering.VolunteeringManagementSystem.service.interfaces.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
    public Optional<Volunteer> getVolunteerByAvailability(String availability) {
        // Converting the availability from String to Enum value
        Availability availabilityStrTOEnum = parseAvailability(availability);

        // Passing the Enum value to the method (findByAvailability)
        return volunteerRepository.findByAvailability(availabilityStrTOEnum);
    }

    @Override
    public Volunteer addVolunteer(Volunteer volunteer) {
        // Set ID for volunteer
        volunteer.setRoleId(volunteer.customIdGenerator(volunteer));
        return volunteerRepository.save(volunteer);
    }

    @Override
    public List<Volunteer> addMultipleVolunteer(List<Volunteer> volunteers) {
        // Set IDs for volunteers
        for(Volunteer volunteer: volunteers)
        {
            String volunteerId = volunteer.customIdGenerator(volunteer);
            volunteer.setRoleId(volunteerId);
        }

        return volunteerRepository.saveAll(volunteers);
    }

    @Override
    public String deleteVolunteer(String volunteerId) {

        Optional<Volunteer> foundVolunteer = volunteerRepository.findById(volunteerId);

        // 1. Checking if volunteer with ID volunteerId is present int the DB
        if(foundVolunteer.isPresent())
        {
            // 2. Delete the volunteer from DB
            volunteerRepository.deleteById(volunteerId);
            return "Volunteer with ID: " + volunteerId + " deleted successfully";
        }
        else
            return "Sorry, volunteer with ID: " + volunteerId + " not found";
    }

    // Update entire volunteer data
    @Override
    public String updateVolunteer(String volunteerId, Volunteer volunteer) {
        Optional<Volunteer> foundVolunteer = volunteerRepository.findById(volunteerId);

        // 1. Checking if volunteer with ID volunteerId is present in DB
        if (foundVolunteer.isPresent()) {
            Volunteer existingVolunteer = foundVolunteer.get();

            // 2. Set the new values
            existingVolunteer.setRoleName(volunteer.getRoleName());
            existingVolunteer.setUsername(volunteer.getUsername());
            existingVolunteer.setPassword(volunteer.getPassword());
            existingVolunteer.setContactInfo(volunteer.getContactInfo());
            existingVolunteer.setRoleType(volunteer.getRoleType());
            existingVolunteer.setSkills(volunteer.getSkills());
            existingVolunteer.setAvailability(volunteer.getAvailability());
            existingVolunteer.setAssignedProjects(volunteer.getAssignedProjects());
            existingVolunteer.setVolunteeringHours(volunteer.getVolunteeringHours());

            // 3. Save the updated volunteer to the database
            volunteerRepository.save(existingVolunteer);
            return "Volunteer with Volunteer ID: " + volunteerId + " updated successfully";
        } else {
            return "Sorry, volunteer with Volunteer ID: " + volunteerId + " not found";
        }
    }

    // Partial update of volunteer data
    @Override
    public String partialUpdateVolunteer(String volunteerId, Map<String, Object> updatedVolunteer) {
        Optional<Volunteer> foundVolunteer = volunteerRepository.findById(volunteerId);

        // Checking if volunteer with ID volunteerId is present in the DB
        if (foundVolunteer.isPresent()) {
            Volunteer existingVolunteer = foundVolunteer.get();

            for (Map.Entry<String, Object> entry : updatedVolunteer.entrySet()) {
                String fieldName = entry.getKey();
                Object fieldValue = entry.getValue();

                // Update the specified field if it exists and the value is not null
                switch (fieldName) {
                    case "roleName":
                        if (fieldValue != null) {
                            existingVolunteer.setRoleName((String) fieldValue);
                        }
                        break;

                    case "username":
                        if (fieldValue != null) {
                            existingVolunteer.setUsername((String) fieldValue);
                        }
                        break;

                    case "password":
                        if (fieldValue != null) {
                            existingVolunteer.setPassword((String) fieldValue);
                        }
                        break;

                    case "contactInfo":
                        if (fieldValue != null) {
                            existingVolunteer.setContactInfo((ContactInfo) fieldValue);
                        }
                        break;

                    case "roleType":
                        if (fieldValue != null) {
                            existingVolunteer.setRoleType((RoleType) fieldValue);
                        }
                        break;

                    case "skills":
                        if (fieldValue != null) {
                            existingVolunteer.setSkills((String) fieldValue);
                        }
                        break;

                    case "availability":
                        if (fieldValue != null) {
                            Availability availability = parseAvailability((String) fieldValue);
                            existingVolunteer.setAvailability(availability);
                        }
                        break;

                    case "assignedProjects":
                        if (fieldValue != null) {
                            existingVolunteer.setAssignedProjects((Set<Project>) fieldValue);
                        }
                        break;

                    case "volunteeringHours":
                        if (fieldValue != null) {
                            existingVolunteer.setVolunteeringHours((int) fieldValue);
                        }
                        break;
                }
            }

            // Save the updated volunteer to the database
            volunteerRepository.save(existingVolunteer);
            return "Volunteer with Volunteer ID: " + volunteerId + " updated successfully";
        } else {
            return "Sorry, volunteer with Volunteer ID: " + volunteerId + " not found";
        }
    }

    // Converting the type of availability value
    private Availability parseAvailability(String availabilityValue) {
        try {
            return Availability.valueOf(availabilityValue);
        } catch (IllegalArgumentException e) {
            // Handle if the provided availabilityValue is not a valid enum constant
            throw new IllegalArgumentException("Invalid availability value: " + availabilityValue);
        }
    }

}
