package com.Volunteering.VolunteeringManagementSystem.repository;

import com.Volunteering.VolunteeringManagementSystem.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {
//    Optional<Project> findByProjectName(String projectName);
    @Query("SELECT p FROM Project p WHERE p.projectName = :projectName")
    Project findByProjectName(@Param("projectName") String projectName);

}
