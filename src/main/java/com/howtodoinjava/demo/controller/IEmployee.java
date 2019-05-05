package com.howtodoinjava.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.howtodoinjava.demo.model.Employee;
@RestController
public interface IEmployee {
	
	@RequestMapping("/")
	public List<Employee> getEmployees();

}
