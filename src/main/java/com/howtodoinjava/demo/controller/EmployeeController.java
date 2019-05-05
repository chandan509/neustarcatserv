package com.howtodoinjava.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.howtodoinjava.demo.model.Employee;

@RestController
public class EmployeeController{
	
	private static List<Employee> employeesList = new ArrayList<Employee>();
	
	@RequestMapping(path = "/", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
    public List<Employee> getEmployees() 
    {
		
		employeesList.add(new Employee(1,"lokesh","gupta","howtodoinjava@gmail.com"));
		return employeesList;
    }
	
	@RequestMapping(path = "/", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	@ResponseBody
    public List<Employee> addEmployee(@RequestBody Employee employee) 
    {
		//List<Employee> employeesList = new ArrayList<Employee>();
		employeesList.add(employee);
		return employeesList;
    }

}
