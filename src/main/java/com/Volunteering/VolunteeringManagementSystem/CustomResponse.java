package com.Volunteering.VolunteeringManagementSystem;

import com.Volunteering.VolunteeringManagementSystem.entity.Volunteer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;


// This class to generate a custom response
// Used in controllers when having send RequestEntity with a body
// --> the body having a msg + list of objects

public class CustomResponse {
    private String message;

    @JsonIgnore
    private List<Volunteer> volunteers;

    CustomResponse(){}

    public CustomResponse(String message, List<Volunteer> volunteers) {
        this.message = message;
        this.volunteers = volunteers;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Volunteer> getVolunteers() {
        return volunteers;
    }

    public void setVolunteers(List<Volunteer> volunteers) {
        this.volunteers = volunteers;
    }


}