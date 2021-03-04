package com.telusko.Telusko;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class Helper {

	@Before("execution(public void show())")
	public void log()
	{
		// some log code
		
		System.out.println("log method called");
		
	}
	
}
