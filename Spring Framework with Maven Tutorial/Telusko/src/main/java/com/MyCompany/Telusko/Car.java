package com.MyCompany.Telusko;

import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle{
	
	public void drive()
	{
		System.out.println("car is driving");
	}

	@Override
	public String toString() {
		return "I am toString from Car";
	}
	
}
