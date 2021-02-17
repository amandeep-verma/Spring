package com.MyCompany.Telusko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Company {
	
//	Autowired Annotation- It assigns the car instance to the Car c without any need of defining it in property under bean tag in xml file
	@Autowired
	private Car c;


	public Car getC() {
		return c;
	}

	public void setC(Car c) {
		this.c = c;
	}

	public void moves()
	{
		System.out.println("Company-> "+ c);
		c.drive();
	}
	
}
