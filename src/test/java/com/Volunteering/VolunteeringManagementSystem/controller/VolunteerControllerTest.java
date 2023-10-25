package com.Volunteering.VolunteeringManagementSystem.controller;

import com.Volunteering.VolunteeringManagementSystem.entity.Availability;
import com.Volunteering.VolunteeringManagementSystem.entity.ContactInfo;
import com.Volunteering.VolunteeringManagementSystem.entity.RoleType;
import com.Volunteering.VolunteeringManagementSystem.entity.Volunteer;
import com.Volunteering.VolunteeringManagementSystem.repository.VolunteerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VolunteerControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private VolunteerRepository volunteerRepository;

    private MockMvc mockMvc;

    // Add final to not changing it
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setUp()
    {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//        {
//            "roleName": "Hassan Abdullah",
//                "username": "Hassan.ab",
//                "password": "hassan@1234",
//                "contactInfo": {
//            "email": "hassan@gmail.com",
//                    "phoneNumber": "+966 59 227 1508"
//        },
//            "roleType": "VOLUNTEER",
//
//                "availability": "PART_TIME",
//                "volunteeringHours": 4
//        }
        ContactInfo contactInfo1 = new ContactInfo("hassan@gmail.com", "+966 59 227 1508");
        Volunteer volunteer = new Volunteer("Hassan Abdullah", "Hassan.ab", "hassan@1234", contactInfo1, RoleType.VOLUNTEER, Availability.PART_TIME, 4);
//        Course course2 = new Course("CS201", "Application Development");
//        courseRepository.saveAll(List.of(course1, course2));
    }


}