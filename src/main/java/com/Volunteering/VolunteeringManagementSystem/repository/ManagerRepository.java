package com.Volunteering.VolunteeringManagementSystem.repository;

import com.Volunteering.VolunteeringManagementSystem.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, String> {
    Manager findByRoleId(String roleId);

    Manager findByUsername(String username);
}
