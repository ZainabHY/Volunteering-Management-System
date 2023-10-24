package com.Volunteering.VolunteeringManagementSystem.controller;

import com.Volunteering.VolunteeringManagementSystem.entity.Manager;
import com.Volunteering.VolunteeringManagementSystem.service.implementations.ManagerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/managers")
public class ManagerController {

    // 1. Autowired the Service Implementation
    @Autowired
    private ManagerServiceImpl managerService;

    // 2. Create Request Methods (GET, POST, DELETE, PUT, PATCH)

    @GetMapping("/")
    public String managerHome()
    {
        return "Welcome | This is the Managers Home";
    }

    // Get all managers --> GET Request
    @GetMapping("/getAllManagers")
    public List<Manager> getAllManagers(){
        return managerService.getAllManagers();
    }


    // Get manager by MANAGER ID --> Using PATH VARIABLE
    @GetMapping("/getManagerById/{managerId}")
    public Optional<Manager> getManagerById(@PathVariable String managerId)
    {
        return managerService.getManagerById(managerId);
    }


    // Adding a new Manager --> POST Request
    @PostMapping("/addManager")
    public Manager addManager(@RequestBody Manager manager)
    {
        return managerService.addManager(manager);
    }

    // Adding multiple new Managers --> POST Request
//    public List<Manager> addMultipleManagers(List<Manager> manager);

    // Delete Manager
    @DeleteMapping("/deleteManager/{managerId}")
    public String deleteManager(@PathVariable String managerId)
    {
        return managerService.deleteManager(managerId);
//        return "The manager with ID: " + managerId + " has deleted successfully";
    }

    // Update Manager
    @PutMapping("/updateManager/{managerId}")
    public String updateManager(@PathVariable String managerId, @RequestBody Manager manager)
    {
        return managerService.updateManager(managerId, manager);
    }


}
