package com.Learner;

/**
 Basic Spring Boot Project.
 You can make an object of Alien class using new keyword. But then we are not using Spring. We can ask spring to give us the object. 
 Firstly we will need object of Application context to get the bean of alien class. We will use already present 
 SpringApplication.run(Udem1Application.class, args) to get its object and later use get getBean() to get alien class beans.
 Also we have to use @Component annotation with the Alien class, which notifies Spring that it will have to make its Object.
 
 */


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Udem1Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Udem1Application.class, args);
		
		
		Alien obje = context.getBean(Alien.class);
		
		obje.code();
		
		
	}

}
