package com.example.demo;

// V3 - 4
/* The run method (SpringApplication.run(SpringBoot1Application.class, args)) is by default present in Spring boot project.
 Project starts with the alien class, its properties, getters and setters. Now to get object of the class we can straight make it
 by using new keyword. But we aren't exploiting the feature of Spring with that. We will make the object of ConfiguratbleApplicationContext
 Now using the object returned by default present method we will use getBean method to get the object of Alien class.
 
 Spring provides a container(Spring Boot Container). It holds the object and they are called SpringBean. The objects can have different scope. So to 
 specify to Spring, the classes for which you need object you have to use @Component annotation. In case user is creating multiple objects of one
 class, the spring will use the same bean(singleton design pattern) of that class to return the object ie. Spring will inject the object in your 
 application. So if user creates 1 or multiple or zero object of a class and we have @component annotation, spring container will have one and only
 one copy of that object retained in the container.

There is also another option of mentioning prototype annotation -> @Scope(value="prototype"). If we use this, it wont create the instance in the 
container by default. It will only create an object when you ask for the instance.

We have another class Laptop, object of which is variable inside Alien class. Now inside the Alien class in order to make its object, we will
have to use Autowired annotation.

When you specify @Component the object in spring container is made with the same name as class name with all letter in lower. You can specify the name
inside @Component("anyname"), now spring container will make object with anyname. For @Autowired to be able to find it, you will use
@Qualifier("anyname") under @Autowired, so spring knows which bean to look for in container to inject it to the underlying object.

*/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBoot1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =  SpringApplication.run(SpringBoot1Application.class, args);
		
		Alien a = context.getBean(Alien.class);
		a.show();
		Alien a2 = context.getBean(Alien.class);
		a2.show();
		
	}
}
