package com.Learner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmployeeResource {
	
	@Autowired
	EmployeeRepo repo;
	
	@GetMapping(path="allEmplot")
	public List<Employee> getemp()
	{
		
		return (List<Employee>)repo.findAll();
	}

}
