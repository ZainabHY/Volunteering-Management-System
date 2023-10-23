# The Structure of the Volunteering Management System
* **UML class diagram**

!["Volunteering MS UML Class Diagram"]('Volunteering Management System.png')
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
