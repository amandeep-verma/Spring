package com.telusko.Telusko;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
  V12 - Spring AOP
 We start with Alien class and to get the object of the spring class we use annotations using java configuration.
 
 Now think of a method in alien class. Now for every method you have some business logic. Also you want to add log, security and other 
 features to it. So you would have to write codes for calling log before calling business logic and after calling besiness logic too.
 This makes code inside method a mess. To call the code from the method without actually writing it inside the method or calling some other
 method we use AOP - Aspect Oriented Programming. Also known as cross cutting concerns.
 To use spring AOP, you have to download the 3 extra jar files. 
 Now in your Helper class to define the class is aspect class you will use Aspect annotation. 
 
 Advice - When - Before , After
 PointCut - Where
 
 So the method inside the Helper class needs to know when it will be called. We have to annotate it for that.
 Also since helper class in in Spring frame work, it needs to be @Component annotated.
 Also we have to use EnableAspectJAutoProxy annotation inside the helper class.
 Now with all this, show() method in alien doesn;t even know but log() method inside helper is called as per definated ie. before or after

 */
public class App 
{
    public static void main( String[] args )
    {
        
    	ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    	Alien a1 = context.getBean(Alien.class);
    	a1.show();
    }
}