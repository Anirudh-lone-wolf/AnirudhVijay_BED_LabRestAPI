# AnirudhVijay_BED_LabRestAPI
## This Repository has solution for Lab 6
* This is a Spring MVC Project built using Spring Boot.
* The main package is : com.glearning.LabSixDebateEvent which conatins the driver class of the application.
* There are 5 sub-packages :
    * com.glearning.LabSixDebateEvent.model - the entity class
    * com.glearning.LabSixDebateEvent.doa - contains an interface which extends JpaRepository for database related operations in spring
    * com.glearning.LabSixDebateEvent.service - which will has an Interface and an implementation class. Here the JpaRepository methods are used for                                                               different CRUD operations required by the use case
    * com.glearning.LabSixDebateEvent.controller - which will have url mappings to perfom different CRUD functionalities in the UI
    * com.glearning.LabSixDebateEvent.security - This contains the Role-Based Authorization code.
    * **com.glearning.LabSixDebateEvent.test -This is the additional packages which conatins a set of dummy values. the evalualtor can use the username and 
                                               password given here to check the application Or, they can enter their own username, password and asscoation in join table through sql queries in MYSQL
* The database used in the Project is MYSQL Database.

