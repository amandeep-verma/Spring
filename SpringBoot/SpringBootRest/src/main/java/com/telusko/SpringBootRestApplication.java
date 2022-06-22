package com.telusko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 V20-21
 Started with adding JPA, sql, JDBC dependencies .
 We have the alien class. We start by making the Alien class, we have annotate it with @XmlRootElement. Further it also needs to be
 annotated with @Entity and the primary key as @Id. So we can use CrudRepository Interface.
 Further make the AlienResourceClass. Annotate the class with @RestController. Make another class - 
 AlienRepository which extends CrudRepository. Now we can make a object of AlienRepository in AlienResource and get its object with
 @Autowired annotation. Next we define a method getAliens() and map it using @RequestMapping
 Instead of @RequestMapping we can straight use @GetMapping, PutMapping, PushMapping, DeleteMapping to define kind of request we are 
 making. 
 We have to add JDBC configuration in application properties.
 
 In Spring you don't have to add any dependency to convert data into JSON format. In Jersey we have moxy and similarly in 
 in Spring we have jackson (pre-built) to convert list of object into JSON.
 
 */

@SpringBootApplication
public class SpringBootRestApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootRestApplication.class, args);
	}
}
