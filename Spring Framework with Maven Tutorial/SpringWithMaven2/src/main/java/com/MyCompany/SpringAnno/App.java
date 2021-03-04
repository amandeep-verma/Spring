package com.MyCompany.SpringAnno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/** V10-11
 * Annotation Based Configuration
 * SpringCore Annotation
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	// Since this is not dependecy injection we dont want this. 
//        Samsung s7 = new Samsung();
//        s7.config();
    	
    	// In order to inject the object, we can ask the factory(ApplicationContext) to give you the object of the class you want
    	// This is different from XML
    	// We have to pass the Annotation class as parametre
    	ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
    	
    	Samsung s7 = factory.getBean(Samsung.class);
    	s7.config();
    	
    	
    	// Now to avoid writing the Bean in AppConfig to get the object for your class we can annotation @Component to all class
    	// to get its object without Beans. To achieve this you also have to add @ComponentScan() annotation to AppConfig class
    	// The SnapDragon class is using @Component so we dont have to write Bean for it.
 
    	// No we make another class MediaTek, now if we run program it will throw error because of confusion of which of 2 class
    	// to chose from. To avoid this we can specify @Primary Annotation to make a class default
    	// The other way of achieving same is by using @Qualifier("defaultClassname") Annotation while making the object of interface
    	// in the class you need. In this case in Samsung class.
    	
    }
}
