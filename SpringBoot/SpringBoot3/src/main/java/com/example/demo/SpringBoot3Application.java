package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 V11-13
 While creating the project, we added 3 dependencies  - web, JPA(Java Persistence API), h2 (inbuilt database(in memory database)
 Create a folder webapp in src->main. Make a jsp home page to accept the things. 
 Make a class Alien.java and further make another class AlienController.java which will be used for controlling the requesting coming from the 
 server. Now also to be able return the file name for a method, we have to add the Jasper dependency
 We are using h2 database, to enable it we have to do something and Spring boot does the auto-config. 
 To enable h2 database, to mention the platform you are using and for url, you'll mention following in application.properties - 
 spring.h2.console.enabled=true
 spring.datasource.platform=h2
 spring.datasource.url=jdbc:h2:mem:testdb
 
 http://localhost:8080/h2-console -> in browser to access the h2 database
 
 All packages created later must be under the pre-existing(main) package.
 Now the database doesn't have table and to add the table we have to enable JPA. To enable JPA we have to use @Entity and @Id annotation in Alien 
 class. Also here we will create a separate data file(data.sql) for storing the some pre-hand data in database.
 Now to be able to perform CRUD operation, we will make an interface AlienRepo extending the CrudRepository interface. We have mention the database name
 (class name) and primary key type. From there we will make a the object of AlienRepo in AlienController and use the annotation @Autowired. This will
 make Spring Boot to make the object of it in its container. Now we just have to call the method save() in home method to save the data from user
 in h2 database.

 We need to have service layer. From here we will create a layer.
 Now to allow user to view data for an alien using user id, we will add another form in home.jsp and make showalien.jsp for output.
 Later you will map the request to a new method in aliencontroller. Here we will use modelandview to send the data back to the jsp.	
	
	
 Spring boot also
 Here we are printing everything on the console from alienfetch method in AlienController. 
 There are some inbuilt methods in CrudRepository interface. We can write method name to search within H2 database and Spring Boot JPA will make
 it for you. There are some protocols on how you would write the method name so Spring Boot JPA can define them itself. The method name should
 start by "findby" and end by a property name what exists in the Alien class. Or you can also end it with "GreaterThan" or similar standards.
 For custom queries, you have to write them in the your interface (here AlienRepo) using @Query annotation and then you can use them.
 	
 */

@SpringBootApplication
public class SpringBoot3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot3Application.class, args);
		
		System.out.println("Main app started");
		
	}
}
    
