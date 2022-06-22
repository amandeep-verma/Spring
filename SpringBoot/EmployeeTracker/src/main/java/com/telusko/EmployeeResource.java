package com.telusko;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeResource {
	
	@Autowired
	EmployeeRepo repo;
	
	@GetMapping(path="employee")
	public List<Employee> allEmp()
	{
		return (List<Employee>)repo.findAll();
	}
	
	@GetMapping(path="employeeFindById/{id}")
	public Optional<Employee> FindById(@PathVariable int id)
	{
		return repo.findById(id);
	}
	
	@GetMapping(path="employeeFindByName/{name}")
	public List<Employee> FindByName(@PathVariable String name)
	{	
		return repo.findByName(name); // Just mention the abstract method in Repo and it takes care of it by itself.
	}
	
	@GetMapping(path="employeeFindByNameId/{name}/{id}")
	public List<Employee> FindByNameId(@PathVariable String name, @PathVariable int id) 
	{	
		return repo.findByNameAndID(name,id); // Write custom query in Repo
	}
	
	
	// employeeFindByName?name=qwer
	@GetMapping(path="employeeFindByName")
	public List<Employee> FindByName1(@RequestParam String name)
	{	
		System.out.println(name);
		return repo.findByName(name);
	}
	
	// employeeTest?score=12,23
	@GetMapping(path="employeeTest")
	public List<Employee> test(@RequestParam("score") List<Integer> points)
	{	
		System.out.println(points);
		return repo.findByPoints(points);
	}
	
	// employeeFindByNamePoints?name=qwer&points=28,70
	@GetMapping(path="employeeFindByNamePoints")
	public List<Employee> FindByNamePoints1(@RequestParam("name") String name, @RequestParam("points") List<Integer> points)
	{	
		return repo.findByNameAndPoints(name,points);
	}
	
	
	// employeeFindByIdNamePoints/101/?name=qwer&points=28,70
	@GetMapping(path="employeeFindByIdNamePoints/{id}")
	public List<Employee> FindByIdNamePoints(@PathVariable int id ,@RequestParam("name") String name, @RequestParam("points") List<Integer> points)
	{	
		System.out.println(id + " " +name +" "+ points );
		return repo.findByIdNamePoints(id, points, name);
//		return repo.findByIdNamePoints(id, name, points);
	}

	
	// By default it takes JSON object
	@PostMapping("employee/add")
	public void addEmp(@RequestBody Employee e)
	{
		if(e.getName()==null)
		{
			System.out.println("Not fetching real value");
			return;
		}
		System.out.println(e);
		repo.save(e);
	}
	
	
	@PutMapping("employee/update/{id}")
	public void update(@PathVariable int id ,@RequestBody Employee e)
	{
		System.out.println("request got here");
		Optional<Employee> newEmp = repo.findById(id);
		
		if(newEmp.isPresent())
		{
			repo.deleteById(id);
			
		}
		repo.save(e);
	}
	
	
	@DeleteMapping("employee/delete/{id}")
	public void delete(@PathVariable int id)
	{
		repo.deleteById(id);
	}
	

	// RequestMapping can take all types of request
	@RequestMapping(path = "addemployee", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public void addEmpl(@RequestBody Employee e)
	{
		if(e.getName()==null)
		{
			System.out.println("Not fetching real value");
			return;
		}
		System.out.println(e);
		repo.save(e);
	}
	
}


