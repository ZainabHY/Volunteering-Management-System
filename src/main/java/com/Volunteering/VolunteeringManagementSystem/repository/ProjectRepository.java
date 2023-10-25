package com.Volunteering.VolunteeringManagementSystem.repository;

import com.Volunteering.VolunteeringManagementSystem.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {
    Optional<Project> findByProjectName(String projectName);
}
