package com.Volunteering.VolunteeringManagementSystem.repository;

import com.Volunteering.VolunteeringManagementSystem.entity.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramRepository extends JpaRepository<Program, String> {
    Program findByProgramName(String programName);
}
