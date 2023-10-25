package com.Volunteering.VolunteeringManagementSystem.service.interfaces;

import com.Volunteering.VolunteeringManagementSystem.entity.Project;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProjectService {
    // Get all Projects --> GET Request
    public List<Project> getAllProjects();

    // Get Project by PROJECT ID --> Using PATH VARIABLE
    public Optional<Project> getProjectById(String projectId);


    // Get project by PROJECT NAME
//    public Optional<Project> getProjectByName(String projectId);

    public Project findByProjectName(String projectName);

    // Get projectS by PROGRAM NAME
    public Optional<Project> getProjectsByProgramName(String projectName);


    // Adding a new Project --> POST Request
    public String addProject(Project project);

    // Adding multiple new Projects --> POST Request
//    public String addMultipleProjects(List<Project> projects);

    // Delete Project
    public String deleteProject(String projectId);

    // Update Project --> PUT
    public String updateProject(String projectId, Project project);

    // Partial Update Project --> PATCH
    // Using MAP instead of HashMap for better type safety and flexibility
    // and to preserve types of the values
//    public String partialUpdateProject(String projectId, Map<String, Object> updatedProject);
}
