package com.Volunteering.VolunteeringManagementSystem.service.implementations;

import com.Volunteering.VolunteeringManagementSystem.entity.Manager;
import com.Volunteering.VolunteeringManagementSystem.repository.ManagerRepository;
import com.Volunteering.VolunteeringManagementSystem.service.interfaces.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    @Override
    public Optional<Manager> getManagerById(@PathVariable String managerId) {
        return managerRepository.findById(managerId);
    }

    @Override
    public Manager addManager(Manager manager) {
        manager.setRoleId(manager.customIdGenerator(manager));
        return managerRepository.save(manager);
    }

    @Override
    public List<Manager> addMultipleManagers(List<Manager> managers) {
        return managerRepository.saveAll(managers);
    }

    @Override
    public String deleteManager(String managerId) {
//        managerRepository.deleteById(managerId);
//        return "Manager with ID: " + managerId + " deleted successfully";

        Optional<Manager> foundManager = managerRepository.findById(managerId);

        // 1. Checking if managerId is present int the DB
        if(foundManager.isPresent())
        {
            // 2. Delete the manager from DB
            managerRepository.deleteById(managerId);
            return "Manager with ID: " + managerId + " deleted successfully";
        }
        else
            return "Sorry, manager with ID: " + managerId + " not found";
    }

    @Override
    public String updateManager(String managerId, Manager manager) {
        Optional<Manager> foundManager = managerRepository.findById(managerId);

        // 1. Checking if manager with ID managerId is present int the DB
        if(foundManager.isPresent())
        {
            // 2. Setting the NEW values
            manager.setRoleName(manager.getRoleName());
            manager.setUsername(manager.getUsername());
            manager.setPassword(manager.getPassword());
            manager.setContactInfo(manager.getContactInfo());
            manager.setRoleType(manager.getRoleType());
            manager.setSupervisedPrograms(manager.getSupervisedPrograms());

            // 3. Save them in DB
            managerRepository.save(manager);
            return "Manager with ID: " + managerId + " updated successfully";
        }
        else
            return "Sorry, manager with ID: " + managerId + " not found";
    }


}
