package com.Volunteering.VolunteeringManagementSystem.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class ContactInfo {
    private String email;
    private String phoneNumber;

    public ContactInfo() {}

    public ContactInfo(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

}
