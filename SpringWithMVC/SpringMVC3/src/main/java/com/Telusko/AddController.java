package com.Telusko;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/*
 V-11 Java Based Configuration
 Here for web.xml we use MyFrontController.java. And for DispatcherServlet we use MvcConfig.java
 
 In MyfrontController, we will modify the methods - getServletMappings() and getRootConfigClasses().
 For getServeltMapping() we will return array of string describing the types of request we will accept. Here that is all(denoted by -"/")
 For getRootConfigClasses(), we have to return an array of classes for configuration.
 
 In MvcConfig.java we have to use EnableWebMvc, Configuration and Component Scan annotations.
 
 */
@Controller
public class AddController 
{
	@RequestMapping("add")
	public ModelAndView add(@RequestParam("t1")int i,@RequestParam("t2")int j)
	{
		
		int k = i+j;
		ModelAndView mv = new ModelAndView();
		mv.addObject("result",k);
		mv.setViewName("result.jsp");

		return mv;
	}
}
