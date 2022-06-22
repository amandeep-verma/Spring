package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// V6-10

/* Chose option of Spring Web, while creating the project. In the folder src->main create a new folder webapp, here all the webpages will 
  be stored. Now we'll have our home.jsp web page in this folder.
  In order to display the webpage we need a controller to accept the request and process. Here for same we make HomeController.java file.

 Spring Boot has auto-configuration which search within itself for the files.
 A method can return a filetype in Spring Boot in form of String. We will have to add Tomcat Jasper dependency in pom.xml from 
 mvnrepositories of the same version of our tomcat-embededcore (Maven Dependency folder)
 Adding the dependencies would straight return the filetype instead of string on the client side.
 
 WebApp is public folder, so you might want to add your files to some other folder. Example here in the folder webapp->pages(we created folder)
 Doing so will result in error because you have to do prefix configuration for the path of the file.
 Also in case you don't want to specify the extension of the file in return type to make the project flexible to other technology we would 
 need to add configuration for the suffix of file. 
 We have to add the these configuration into the application.properties file.
 
 In order to send-receive data from server we can use HttpServletRequest object in the method and receive the data from the webpage and using a 
 session we can send the data. Now instead of doing the things with the  HttpServletRequest and Session, we can use RequestParam annotation 
 to access the data from client side and to send the data back, we can use ModelView.
 
 Now we create a class alien and accept the data for it using the index.html and in the method alien process, we are straight accepting the alien 
 object as the name of the parameters being passed from html are same as for alien object, Spring boot will assign them to object. We dont have to 
 manually accept each one as parameter and assign them to alien object.
 
 */

@SpringBootApplication
public class SpringBoot2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2Application.class, args);
		
		
		System.out.println("Am the main method");
	}

}
