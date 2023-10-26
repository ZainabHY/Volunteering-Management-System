package com.Volunteering.VolunteeringManagementSystem.controller;

import com.Volunteering.VolunteeringManagementSystem.entity.Availability;
import com.Volunteering.VolunteeringManagementSystem.entity.ContactInfo;
import com.Volunteering.VolunteeringManagementSystem.entity.RoleType;
import com.Volunteering.VolunteeringManagementSystem.entity.Volunteer;
import com.Volunteering.VolunteeringManagementSystem.repository.VolunteerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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


//        Volunteer volunteer = new Volunteer("Hassan Abdullah", "Hassan.ab", "hassan@1234", contactInfo1, RoleType.VOLUNTEER, Availability.PART_TIME, assignedProjects, 4);
//        Volunteer course2 = new Volunteer("CS201", "Application Development");
//        volunteerRepository.saveAll(List.of(volunteer1, volunteer2));
    }


    @AfterEach
    public void tearDown()
    {
        volunteerRepository.deleteAll();
    }

    @Test
    public void getAllVolunteersTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/volunteers"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Website"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Application"));

    }

    @Test
    void PostVolunteerTest() throws Exception {
//Create a new object to add
//        Volunteer newVolunteer = new Volunteer("CS606", "Any new volunteer");
// Convert the object to JSON
//        String requestBody = objectMapper.writeValueAsString(newVolunteer);
//MockMvc post request
//        MvcResult mvcResult = mockMvc.perform(post("/volunteers/add")
//                        .content(requestBody)
//                        .contentType(MediaType.APPLICATION_JSON)
//                )
//                .andExpect(status().isOk())
//                .andReturn();
//        assertTrue(mvcResult.getResponse().getContentAsString().contains("Volunteer Added Successfully"));
    }

}