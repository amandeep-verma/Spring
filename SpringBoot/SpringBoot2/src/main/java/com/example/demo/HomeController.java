package com.example.demo;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("home")
	public ModelAndView home(@RequestParam("name")String myName)
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("name",myName);
		mv.setViewName("home"); 
		
		System.out.println("hi "+myName);
		return mv;
	}
	// http://localhost:8080/home?name=qwq - requesting webpage
	
	
	@RequestMapping("alienated")
	public ModelAndView alienprocess(Alien a)
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("obj",a);
		mv.setViewName("result");
		
		System.out.println(a);
		return mv;
	}
	
//	public String home(HttpServletRequest req)
//	{
//		String name = req.getParameter("name");
//		HttpSession sess = req.getSession();
//		sess.setAttribute("name", name);
//		System.out.println("hi "+name);
//		return "home";
//	}
	
}
