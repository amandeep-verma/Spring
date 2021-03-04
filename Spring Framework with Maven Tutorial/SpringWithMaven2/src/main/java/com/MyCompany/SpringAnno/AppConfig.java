package com.MyCompany.SpringAnno;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


// Since the class is configuration class, we have to mention the tag
@Configuration
// To scan the predefined components
@ComponentScan(basePackages = "com.MyCompany.SpringAnno")
public class AppConfig {

	// We have to use the bean tag to specify that this method is Bean.
	@Bean
	public Samsung getPhone()
	{
		return new Samsung();
	}
	
	
	// Instead of this we can write @Component annotation to both mediatek and snapdragon class, and define either of them 
	// @Primary so system knows which one to use to make an object. Also you can use @Qualifier in Samsung class to define the 
	// default class to be called to make the object.
//	@Bean
//	public MobileProcessor process()
//	{
//		return new MediaTek();
//	}
	
	
}


