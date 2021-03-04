package com.MyCompany.Telusko;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * v2-9
 * 
 * 5 - getBean, XML based configuration
 * 6 - annotation based configuration
 * 7 - Setter Injection
 * 8 - Constructor Injection
 * 9 - Autowired Annotation
 *The program began with adding the spring dependency in pom.xml file. 
 *For main program to call method of bike or car, we have to change the specific class of the object each time while creating it.
 *We can avoid it by making an interface (Vehicle) but even for that we have to change the class interface is referring to.
 *So we use Spring framework to avoid the dependency. 
 *We use getbean method and pass a keyword. In order to access the getBean method, we have to make object of ApplicationContext.
 *From there we use spring.xml file to link keyword to class.
 *Now in spring.xml we can change reference of keyword vehicle to bike or car and the program will refer to that class.
 *The configuration can be done by xml , annotation and java configuration. 
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	// Here we have to change classes each time 
//        Car c = new Car();
//        c.drive();
//        Bike b = new Bike();
//        b.drive();
    	
    	// Here we have to change the class Vehicle is referring to.
//    	Vehicle obj = new Car();
//    	obj.drive();
    	
    	
    	//getBean can be called from either of interface  BeanFactory or ApplicationContext. ApplicationContext is better choice
    	// ApplicationContext is interface to make its object we will use ClassPathXmlApplicationContext() class. 
    	// Also we pass the .xml file as parameter so the program knows which file to refer to 
    	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    	
    	// context.getBean gives object of Object class. So we have to cast it.
    	
    	// Now "vehicle" is keyword and to refer it to some class we have to link to a class using .xml
    	// So have to create a XML file for xml configuration
    	Vehicle objVehicle = (Vehicle) context.getBean("vehicle");
    	objVehicle.drive();
    	
    	
    	// For Annotation based configuration, we don't have a bean named "car" in xml file
    	// We can specify annotation based configuration in car class by specifying @Component
    	// We also have to specify in xml file that we have written the annotation based configuration(check spring.xml)
    	objVehicle = (Vehicle) context.getBean("car"); //The default name is non-qualified and de-capitalized. 
    	objVehicle.drive();
    	
    	// bean properties
    	// We have variable in Tyre class, so to set the variable we use Spring.xml file
    	Tyre t = (Tyre)context.getBean("tyre");
    	System.out.println(t);
    	
    	// The varibale in class Engine can be set using constructor from Spring.xml file
    	Engine e = (Engine)context.getBean("engine");
    	System.out.println(e);
    	
    	// Since car is property of company class, if we were to define company bean tag in xml, we should be defining the car property
    	// in property tag. But we are using annotation for Company class so to automatically assign the instance of Car class to 
    	// car property we use Autowired Annotation.
    	// The company class shows how Autowired Annotation are used. 
    	Company c = (Company)context.getBean("company");
    	c.moves();
    }
}
