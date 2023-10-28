package com.Volunteering.VolunteeringManagementSystem.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.Volunteering.VolunteeringManagementSystem.entity.*;
import com.Volunteering.VolunteeringManagementSystem.repository.ProjectRepository;
import com.Volunteering.VolunteeringManagementSystem.repository.VolunteerRepository;
import com.Volunteering.VolunteeringManagementSystem.service.implementations.VolunteerServiceImpl;
import com.Volunteering.VolunteeringManagementSystem.service.interfaces.VolunteerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//@RunWith(SpringRunner.class)
@SpringBootTest // Used to loa the Spring Application Context
@AutoConfigureMockMvc // Ensures that MocMvc instance is automatically configured
class VolunteerControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private VolunteerRepository volunteerRepository;
//    @Autowired
//    private VolunteerService volunteerService;

    @Autowired
    private ProjectRepository projectRepository;


    private MockMvc mockMvc;

    // Add final to not changing it
    private final ObjectMapper objectMapper = new ObjectMapper();


    // Creating objects in the Repositories before each test
    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        // Creating objects from Project and Volunteer and save them in db

        ContactInfo contactInfo1 = new ContactInfo("email1", "phoneNumber1");
        ContactInfo contactInfo2 = new ContactInfo("email2", "phoneNumber2");

        Project project1 = new Project("Project Name", "Project Description", "Project Location", "Project Duration", ProjectStatus.PLANNED);
        Project savedProject1 = projectRepository.save(project1);
        List<Project> assignedProjects1 = new ArrayList<>();
        assignedProjects1.add(savedProject1);

        Project project2 = new Project("Project Name2", "Project Description2", "Project Location2", "Project Duration2", ProjectStatus.PLANNED);
        Project savedProject2 = projectRepository.save(project2);
        List<Project> assignedProjects2 = new ArrayList<>();
        assignedProjects2.add(savedProject2);


        Volunteer volunteer1 = new Volunteer("Name1", "username1", "name1@1234", contactInfo1, Availability.PART_TIME, assignedProjects1, 4);
//        Volunteer volunteer1 = new Volunteer("Hassan Abdullah", "Hassan.ab", "hassan@1234", contactInfo1, Availability.PART_TIME, assignedProjects1, 4);
        Volunteer volunteer2 = new Volunteer("Name2", "username2", "name2@1234", contactInfo2, Availability.FULL_TIME, assignedProjects2, 6);
        volunteerRepository.saveAll(List.of(volunteer2));
    }

    // Clear the Repositories after each test
    @AfterEach
    public void tearDown()
    {
        volunteerRepository.deleteAll();
        projectRepository.deleteAll();
    }

    // Testing the GET method for retrieving ALL Volunteers
//    @Test
//    public void getAllVolunteers() throws Exception
//    {
//        MvcResult mvcResult = mockMvc.perform(get("/volunteers/getAllVolunteers"))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
//                .andReturn();
//
////        assertTrue(mvcResult.getResponse().getContentAsString().contains("Name2"));
//        // this as same as ^ but to make it easier to read
//        String responseJson = mvcResult.getResponse().getContentAsString();
//
//    // Making versions in the assertion
//    // --> to account any difference could cause the assertions to fail
//
//        // Normal Assertion
//        assertTrue(responseJson.contains("Name1"));
//        assertTrue(responseJson.contains("Name2"));
//
//        // Assertion with trimming the string responseJson
//        assertTrue(responseJson.trim().contains("Name1"));
//        assertTrue(responseJson.trim().contains("Name2"));
//
//        // Assertion with converting the string responseJson to lower cate
//        assertTrue(responseJson.toLowerCase().contains("Name1"));
//        assertTrue(responseJson.toLowerCase().contains("Name2"));
//
//        // Assertion with converting the string responseJson to upper cate
//        assertTrue(responseJson.toUpperCase().contains("Name1"));
//        assertTrue(responseJson.toUpperCase().contains("Name2"));
//
//
//
//    }

    @Test
    public void getAllVolunteers() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/volunteers/getAllVolunteers"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String responseJson = mvcResult.getResponse().getContentAsString();

        // Define the expected JSON value
        String expectedJson = "{\"message\":\"\\n--- These are all volunteers ---\"}";

        // Print the expected value
        System.out.println("Expected: " + expectedJson);

        // Print the actual value
        System.out.println("Actual: " + responseJson);

        // Assertions
        assertEquals(expectedJson, responseJson);
    }

///////////////////////////////
    @Test
    void testAddVolunteer() throws Exception {
        // Prepare test data

        ContactInfo contactInfo3 = new ContactInfo("email3", "phoneNumber3");

        Project project3 = new Project("Project Name3", "Project Description3", "Project Location3", "Project Duration3", ProjectStatus.PLANNED);
        Project savedProject3 = projectRepository.save(project3);
        List<Project> assignedProjects3 = new ArrayList<>();
        assignedProjects3.add(savedProject3);
        Volunteer volunteer3 = new Volunteer("Name3", "username3", "name3@1234", contactInfo3, Availability.FULL_TIME, assignedProjects3, 6);


        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(volunteer3);

        MvcResult mvcResult = mockMvc.perform(post("/volunteers/addVolunteer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Name2"));
        // this as same as ^ but to make it easier to read
        String response = mvcResult.getResponse().getContentAsString();


        // Verify the response
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals("Provided volunteer Name3 is added successfully", response);
        assertTrue(response.contains("successfully"));
    }

//    @Test
//    void testGetVolunteers() {
//        // Call the controller method
//        ResponseEntity<List<Volunteer>> response = volunteerController.getVolunteers();
//
//        // Verify the response
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        List<Volunteer> volunteers = response.getBody();
//        assertNotNull(volunteers);
//        assertEquals(2, volunteers.size());
//        // Add more assertions as needed
//    }


}