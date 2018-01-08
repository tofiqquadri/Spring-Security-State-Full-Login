package com.codeinsight.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codeinsight.bean.UiEmployee;
import com.codeinsight.service.EmployeeService;

@RestController
public class EmployeeController {

	@Resource
	private EmployeeService employeeService;

	
	//CREATE AN EMPLOYEE
	@PostMapping( path = { "/employee/create" } )
	public void createEmployee( @RequestBody UiEmployee employee)
	{
		
		employeeService.addNewEmployee(employee);
		
	}
	
	//DELETE AN EMPLOYEE BY ID
	
	//GET ALL EMPLOYEES
	@GetMapping( path = { "/employee/getall" } )
	public @ResponseBody List<UiEmployee> getAllEmployees( )
	{
		
		List<UiEmployee> beans = new ArrayList<>();
		
		beans = employeeService.getAllEmployees();
		
		return beans;
		
	}
	
	
	//GET AN EMPLOYEE BY ID
	
	
}
