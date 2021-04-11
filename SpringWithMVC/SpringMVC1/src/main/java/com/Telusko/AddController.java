package com.Telusko;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Telusko.service.AddService;


// v1-9 
/*
 In spring, we start with index.jsp. From there instead of straight passing the request from xml to servlet, we 
 pass it to DispatcherServlet(Front Controller). All the request in Spring goes to DispatcherServlet.
 All the servlets needs to be annotated with Controller. 
Request from client goes to xml. From xml it goes to DispatcherServlet and from there DispatcherServlet the request
goes to the respective Controller. 
So the program starts with the maven project, we select archtype-webapp kind of project. If there are any errors,
check for targeted runtime from properties of the project and add the server. 
From there edit the index.jsp for your request from the client and form action= SomeName. Now from here the request will
go to web.xml. We have to add the code(for servlet tags) to send the request to front controller which is done as shown 
in .xml file. The servlet name is used to create the DispatcherServlet file. Also check url pattern, we leave it with /
symbol which means for all the request it will call dispatcherservlet. 
<servlet-class>  in xml have DispatcherServlet, you can check it. So to use this we need to import those libraries in 
pom.xml file. 
After importing those libraries, you would create a new .xml file. Now this is DispatcherServlet and to name it you will
use the <servlet-name> from web.xml. So the name is ******-servlet.xml. ****** is <servlet-name>. 
Again in ******-servlet.xml, you have to add the bean tags. Make sure to change the base package to your base package in 
src->main->java. So as it should know which package to look in for the servlet. 
You would make a java file in your package which is the controller file. You will add Controller annotation to it. Here you will
 make the method for processing the request. In the Controller file ie- this one, for the method you want to call for the 
 particular request you have to mention the RequestMapping annotation with the request name inside. Now this method will take 
 the parameters as HttpServletRequest and HttpServletResponse in order to take the data. We will pass the data to service class.
 All the logical processing should be done in service class. So we will make the service class inside a new package defined in 
 the old package. In the service class, we will process the data and send it back. We will store the data using variables.
 
 In same method, to send the value back to client we will use ModelAndView class by creating its object. We have to specify 2 
 things for it. First, the setviewname() to define the view you want to call. Second, the addObject() to define what data you 
 want to send. And you will return the object of ModelView.
 The file(display.jsp) receiving the data will define how to display it on the user side.


 Instead of using Httpservlet request and and response objects to fetch the value of input, we can straight obtain the values in parameters
 passing to function  by using the RequestParam annotation.

 */


@Controller
public class AddController {
	
	@RequestMapping("/add")
	public ModelAndView add(@RequestParam("t1") int i, @RequestParam("t2") int j)
	//public ModelAndView add(HttpServletRequest request, HttpServletResponse response)
	{
		
//		int i = Integer.parseInt(request.getParameter("t1"));
//		int j = Integer.parseInt(request.getParameter("t2"));
		
		AddService as = new AddService();
		int k = as.add(i, j);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display.jsp");
		mv.addObject("result",k);
		
		return mv;
	}
}
