//package com.Volunteering.VolunteeringManagementSystem.service.implementations;
//
//import com.Volunteering.VolunteeringManagementSystem.entity.Manager;
//import com.Volunteering.VolunteeringManagementSystem.repository.ManagerRepository;
//import com.Volunteering.VolunteeringManagementSystem.service.interfaces.ManagerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ManagerServiceImpl implements ManagerService {
//
//    @Autowired
//    private ManagerRepository managerRepository;
//
//    @Override
//    public List<Manager> getAllManagers() {
//        return managerRepository.findAll();
//    }
//
//    @Override
//    public Optional<Manager> getManagerById(@PathVariable String managerId) {
//        return managerRepository.findById(managerId);
//    }
//
//    @Override
//    public Manager addManager(Manager manager) {
//        return managerRepository.save(manager);
//    }
//
//    @Override
//    public List<Manager> addMultipleManagers(List<Manager> managers) {
//        return managerRepository.saveAll(managers);
//    }
//
//    @Override
//    public void deleteManager(String managerId) {
//        managerRepository.deleteById(managerId);
////        return "Manager with ID: " + managerId + " deleted successfully";
//    }
//}
