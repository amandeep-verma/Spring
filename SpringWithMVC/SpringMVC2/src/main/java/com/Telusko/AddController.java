package com.Telusko;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Telusko.service.AddService;


/*
 V-10
 Can we replace telusko-servlet.xml and web.xml from last project. Yes by using annotation based configuration. 
 First we replace telusko-servlet.xml(Dispatcher Servlet). We use java class for that. Here we are naming it teluskoconfig (can be any name). 
 To declare it is config file we will use @Configuration annotation and next we ll use component scan annotation to mention the packages
 location inside it as array in parameter.
 Also to replace web.xml we ll make another class but for this you have to extend the AbstractAnnotationConfigDispatcherServletInitializer class.
 We ll use method getServletMappings()  to set the mapping by passing the string of array of request type. Here use will use "/".
 We ll use getServletConfigClasses() and return the class for configuration(Telusko-config)
 
 We  dont't need the dispatcherServlet xml file and we will not have anything in web.xml file.
 
 Now imagine in future we re changing our view technology so we might not want to mention the extension in the addcontroller file.
 In telusko Config we can mention a method . We have to create and return the object of InternalResourceViewResolver (responsible to search for 
 view name). We create the object of the InternalResourceViewResolver and set suffix (for absolute path) and prefix(for extension of file) and
 return it.
 
 */


@Controller
public class AddController {

	@RequestMapping("/add")
	public ModelAndView add(@RequestParam("t1") int i, @RequestParam("t2") int j)
	{
		
		AddService as = new AddService();
		int k = as.add(i, j);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display");
		mv.addObject("result",k);
		
		return mv;
	}
}
