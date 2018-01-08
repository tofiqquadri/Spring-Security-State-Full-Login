package com.codeinsight.service;

import java.util.List;

import com.codeinsight.bean.UiEmployee;

public interface EmployeeService {

	public void addNewEmployee(UiEmployee employee);
	
	public List<UiEmployee> getAllEmployees();
	
}
