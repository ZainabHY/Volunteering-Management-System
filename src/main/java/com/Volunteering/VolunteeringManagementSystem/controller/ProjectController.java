package com.Volunteering.VolunteeringManagementSystem.controller;

import com.Volunteering.VolunteeringManagementSystem.entity.Program;
import com.Volunteering.VolunteeringManagementSystem.entity.Project;
import com.Volunteering.VolunteeringManagementSystem.service.implementations.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    
    @Autowired
    private ProjectServiceImpl projectService;

    @GetMapping("/")
    public String projectHome()
    {
        return "Welcome | This is the Projects Home";
    }

    // Get all projects --> GET Request
    @GetMapping("/getAllProjects")
    public List<Project> getAllProjects(){
        return projectService.getAllProjects();
    }


    // Get project by PROGRAM ID --> Using PATH VARIABLE
    @GetMapping("/getProjectById/{projectId}")
    public Optional<Project> getProjectById(@PathVariable String projectId)
    {
        return projectService.getProjectById(projectId);
    }

    // Get project by PROGRAM NAME --> Using PATH VARIABLE
    @GetMapping("/findByProjectName/{projectName}")
    public Project getProjectByName(@PathVariable String projectName)
    {
        return projectService.findByProjectName(projectName);
    }

    // Adding a new Project --> POST Request
    @PostMapping("/addProject")
    public String addProject(@RequestBody Project project)
    {
        return projectService.addProject(project);
    }

    // Delete Project
    @DeleteMapping("/deleteProject/{projectId}")
    public String deleteProject(@PathVariable String projectId)
    {
        return projectService.deleteProject(projectId);
    }


}
