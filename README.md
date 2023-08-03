# AnirudhVijay_BED_LabRestAPI
## This Repository has solution for Lab 6

* This is a Spring MVC Project built using Spring Boot.
* The main package is : com.glearning.LabSixDebateEvent which conatins the driver class of the application.
* There are 6 sub-packages :
    * com.glearning.LabSixDebateEvent.model - the entity class
    * com.glearning.LabSixDebateEvent.doa - contains an interface which extends JpaRepository for database related operations in spring
    * com.glearning.LabSixDebateEvent.service - which will has an Interface and an implementation class. Here the JpaRepository methods are used for                                                               different CRUD operations required by the use case
    * com.glearning.LabSixDebateEvent.controller - which will have url mappings to perfom different CRUD functionalities in the UI
    * com.glearning.LabSixDebateEvent.security - This contains the Role-Based Authorization code.
    * **com.glearning.LabSixDebateEvent.test -This is the additional package which conatins a set of dummy values. The assessment evalualtor can use the username and password given here to check the application or, they can enter their own username, password and association in join table through sql queries in MYSQL**
* The database used in the Project is MYSQL Database. **PLEASE ENTER YOU OWN MYSQL PASSWORD IN application.properties**
* **Please keep in mind  that you will need to add values directly in MYSQL if you want to enter your own username, password and role. Also, make sure to enter values in the users_roles join table which is created on sunccessful application run to create association between the user and their correspond role**

