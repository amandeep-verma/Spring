package com.telusko;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface  EmployeeRepo extends CrudRepository<Employee, Integer>{

	List<Employee> findByName(String name);

	@Query("from Employee where name= :aname and id= :aid")
	List<Employee> findByNameAndID(@Param("aname") String name, @Param("aid") int id);

	@Query("from Employee where points IN :Epoints")
	List<Employee> findByPoints(@Param("Epoints") List<Integer> points);

	@Query("from Employee where name= :aname AND  points IN :Epoints")
	List<Employee> findByNameAndPoints(@Param("aname") String name, @Param("Epoints") List<Integer> points);

//	@Query("from Employee where id= :aid AND name: aname AND points IN :Epoints")
	@Query("from Employee where id= :aid AND  points IN :Epoints AND name= :aname ")
	List<Employee> findByIdNamePoints(@Param("aid") int id, @Param("Epoints") List<Integer> points, @Param("aname") String name);

	//  AND name= :aname      , @Param("aname") String name,
	
}
