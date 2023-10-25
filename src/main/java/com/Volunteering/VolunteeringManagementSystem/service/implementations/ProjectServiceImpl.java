package com.Volunteering.VolunteeringManagementSystem.service.implementations;

import com.Volunteering.VolunteeringManagementSystem.entity.Manager;
import com.Volunteering.VolunteeringManagementSystem.entity.Program;
import com.Volunteering.VolunteeringManagementSystem.entity.Project;
import com.Volunteering.VolunteeringManagementSystem.repository.ProgramRepository;
import com.Volunteering.VolunteeringManagementSystem.repository.ProjectRepository;
import com.Volunteering.VolunteeringManagementSystem.service.interfaces.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class ProjectServiceImpl implements ProjectService {
    
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProgramRepository programRepository;
    
    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Optional<Project> getProjectById(String projectId) {
        return projectRepository.findById(projectId);
    }

    @Override
    public Optional<Project> getProjectByName(String projectName) {
        return projectRepository.findByProjectName(projectName);
    }

    @Override
    public Optional<Project> getProjectsByProgramName(String projectId) {
        return Optional.empty();
    }

    @Override
    public String addProject(Project project) {
        String msg = "";
        // Set ID for project
        String projectId = project.generateId();
        project.setProjectId(projectId);

        //Save the project with the associated manager
        // By retrieving the manager id and look if it is exists
        Program program = programRepository.findByProgramId(project.getProgram().getProgramId());
        if (program != null)
        {
            project.setProgram(program);
            projectRepository.save(project);
            msg = "Project " + project.getProjectName() + " added successfully!";
        }
        else
            msg = "Sorry, manager with ID " + project.getProgram().getProgramId() + " not found";

        return msg;
    }

    @Override
    public String addMultipleProjects(List<Project> projects) {
        return null;
    }

    @Override
    public String deleteProject(String projectId) {
        Optional<Project> foundProject = projectRepository.findById(projectId);

        // 1. Checking if project with ID projectId is present int the DB
        if(foundProject.isPresent())
        {
            // 2. Delete the project from DB
            projectRepository.deleteById(projectId);
            return "Project with ID: " + projectId + " deleted successfully";
        }
        else
            return "Sorry, project with ID: " + projectId + " not found";
    }

    @Override
    public String updateProject(String projectId, Project project) {
        return null;
    }

    @Override
    public String partialUpdateProject(String projectId, Map<String, Object> updatedProject) {
        return null;
    }
}
