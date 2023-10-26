# The Structure of the Volunteering Management System
* **UML class diagram**



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


##Controllers and Routes structure

## Extra links
   **Volunteering Management System Presentation:**
   https://docs.google.com/presentation/d/1EOxj1KYtBlxg51Q9ASDxpcCG-WVED83NNQhm80lb_xk/edit?usp=sharing
   **Trello Managemnt**
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
