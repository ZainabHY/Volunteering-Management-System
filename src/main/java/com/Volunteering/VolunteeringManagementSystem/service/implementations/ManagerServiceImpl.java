package com.Volunteering.VolunteeringManagementSystem.service.implementations;

import com.Volunteering.VolunteeringManagementSystem.entity.Manager;
import com.Volunteering.VolunteeringManagementSystem.entity.Volunteer;
import com.Volunteering.VolunteeringManagementSystem.repository.ManagerRepository;
import com.Volunteering.VolunteeringManagementSystem.service.interfaces.ManagerService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.apache.catalina.realm.UserDatabaseRealm.getRoles;

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
    public String addManager(Manager manager) {
        manager.setRoleId(manager.customIdGenerator(manager));
        managerRepository.save(manager);
        return "Manager " + manager.getRoleName() + " is added successfully";
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
            // 2. Getting the found manager to update it to the same ID
            Manager existingManager= foundManager.get();

            // 3. Setting the NEW values
            existingManager.setRoleName(manager.getRoleName());
            existingManager.setUsername(manager.getUsername());
            existingManager.setPassword(manager.getPassword());
            existingManager.setContactInfo(manager.getContactInfo());
            existingManager.setRoleType(manager.getRoleType());
            existingManager.setSupervisedPrograms(manager.getSupervisedPrograms());

            // 4. Save them in DB
            managerRepository.save(existingManager);
            return "Manager with ID: " + managerId + " updated successfully";
        }
        else
            return "Sorry, manager with ID: " + managerId + " not found";
    }

    ////////////////////////////////////////////////////////////////
    // FOR Configure Authentication
    ////////////////////////////////////////////////////////////////

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Manager manager = managerRepository.findByUsername(username);
//        if (manager == null) {
//            throw new UsernameNotFoundException("Manager not found with username: " + username);
//        }
//        return new org.springframework.security.core.userdetails.User(
//                manager.getUsername(), manager.getPassword(), getRoles((User) manager)
//        );
//    }

//    private List<GrantedAuthority> getRoles(Manager manager) {
//        // Return the list of roles for the manager
//        // Convert your role entities to GrantedAuthority objects
//        // For example:
//        return manager.getRoles().stream()
//                .map(role -> new SimpleGrantedAuthority(role.getName()))
//                .collect(Collectors.toList());
//    }



}
