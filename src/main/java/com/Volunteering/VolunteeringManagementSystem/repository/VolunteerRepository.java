package com.Volunteering.VolunteeringManagementSystem.repository;

import com.Volunteering.VolunteeringManagementSystem.entity.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolunteerRepository extends JpaRepository<Volunteer, String> {
}
