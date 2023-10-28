# The Structure of the Volunteering Management System



**Description of the project**
A streamlined system for managing volunteers and projects within programs
**Roles:** Managers oversee projects, while Volunteers actively participate 
   Programs group projects, enabling efficient organization and coordination
Simplifies administration and enhances effectiveness of volunteer programs

**Class Diagram**
![alt text](https://github.com/ZainabHY/Volunteering-Management-System/blob/main/Volunteering%20Management%20System.png) 


**Setup**
* Installing Java
* Installiing Spring Boot
* Adding dependencies
   * Spring Web
   * Spring Boot DevTools
   * Spring Data JPA
   * MySQL Driver
   * Lombok
* Clone repository
   * **In Terminal:**
     git clone https://github.com/ZainabHY/Volunteering-Management-System.git

## Technologies Used
   * IntelliJ
   * Postman

## Controllers and Routes structure
   * **Managers**
     * Managers Home (**GET**) --> localhost:8080/managers/
     * Get All Managers (**GET**) --> localhost:8080/managers/getAllManagers
     * Add Manager (**POST**) --> localhost:8080/managers/addManager
     * Delete Manager (**DELETE**) --> localhost:8080/managers/deleteManager/{managerId}
     * Update Manager (**PUT**) --> localhost:8080/managers/updateManager/{managerId}
       
   * **Volunteers**
     * Volunteers Home (**GET**) --> localhost:8080/volunteers/
     * Get All Volunteers (**GET**) --> localhost:8080/volunteers/getAllVolunteers
     * Get Volunteer By ID (**GET**) --> localhost:8080/volunteers/getVolunteerById/{volunteerId}
     * Get Volunteer By Availability (**GET**) --> localhost:8080/volunteers/getVolunteerById/{availability}
     * Add Volunteer (**POST**) --> localhost:8080/volunteers/addVolunteer
     * Add Multiple Volunteers (**POST**) --> localhost:8080/volunteers/addMultipleVolunteers
     * Delete Volunteer (**DELETE**) --> localhost:8080/volunteers/deleteVolunteer/{volunteerId}
     * Update Volunteer (**PUT**) --> localhost:8080/volunteers/updateVolunteer/{volunteerId}
     * Update Volunteer (**PATCH**) --> localhost:8080/volunteers/partialUpdateVolunteer/{volunteerId}
    
   * **Programs**
     * Programs Home (**GET**) --> localhost:8080/programs/
     * Get All Programs (**GET**) --> localhost:8080/programs/getAllPrograms
     * Get Program By ID (**GET**) --> localhost:8080/programs/getProgramById/{programId}
     * Get Program By Name (**GET**) --> localhost:8080/programs/getProgramByName/{programName}
     * Add Program (**POST**) --> localhost:8080/programs/addProgram
     * Add Multiple Programs (**POST**)--> localhost:8080/programs/addMultiplePrograms
     * Delete Program (**DELETE**) --> localhost:8080/programs/deleteProgram/{programId}
     * Update Program (**PUT**)--> localhost:8080/programs/updatePrograms/{programId}
     
   * **Projects**
     * Projects Home (**GET**) --> localhost:8080/projects/
     * Get Project By Name (**GET**) --> localhost:8080/projects/findByProjectName/{projectName}"
     * Get All Projects (**GET**) --> localhost:8080/projects/getAllProjects
     * Add Projects (**POST**) --> localhost:8080/projects/getProjectById/{projectId}
     * Delete Projects (**DELETE**) --> localhost:8080/projects/addProject/{projectId}

## Extra links
   * **Volunteering Management System Presentation:**
   https://docs.google.com/presentation/d/1EOxj1KYtBlxg51Q9ASDxpcCG-WVED83NNQhm80lb_xk/edit?usp=sharing
   * **Trello Managemnt**
   https://trello.com/b/LdRbBB7a/mid-project-volunteering-system

## Future Work
   * Adding tests
   * Creating security

## Resources 
   * https://github.com/raneemr05/springdatajpa
   * https://stackoverflow.com/







**Steps for Service and Controller Layers**

**1. Service Interface**
    * Define the methods

**2. Service Implementation**
    * Implements Service Interface
    * @Autowired the Repository
    * Create the implementations of the methods

**3. Controller**
    * @Autowired the Service Implementation
    * Create Request Methods (GET, POST, DELETE, PUT, PATCH)
