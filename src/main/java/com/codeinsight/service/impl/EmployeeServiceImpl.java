package com.codeinsight.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codeinsight.bean.UiEmployee;
import com.codeinsight.converter.EmployeeConverter;
import com.codeinsight.dao.EmployeeDao;
import com.codeinsight.entity.Employee;
import com.codeinsight.service.EmployeeService;

@Service
@Transactional( readOnly = true )
public class EmployeeServiceImpl implements EmployeeService{

	@Resource
	private EmployeeDao employeeDao;
	
	@Resource
	private EmployeeConverter employeeConverter;
	
	@Transactional( readOnly = false)
	@Override
	public void addNewEmployee(UiEmployee employee) {
		// TODO Auto-generated method stub
		
		Employee entity = employeeConverter.getEntityFromBean( employee );
		
		employeeDao.create(entity);
		
	}

	@Override
	public List<UiEmployee> getAllEmployees() {
		// TODO Auto-generated method stub
		
		List<Employee> entities = new ArrayList<>();
		
		entities = employeeDao.findAll();
		
		List<UiEmployee> beans = new ArrayList<>();
		
		beans = employeeConverter.getBeansFromEntities(entities);
		
		return beans;
	}
	
}
