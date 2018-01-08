package com.codeinsight.dao;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.codeinsight.entity.Employee;

@Repository
public class EmployeeDao extends AbstractDao<Employee>{

	private StringBuilder hql; 
	
	public EmployeeDao() {
		super(Employee.class);
        hql = new StringBuilder(); 
	}
	
	public Employee findByUsername(String userName)
	{
		hql.append( "SELECT employee " );
		hql.append( "FROM Employee employee " );
		hql.append( "WHERE 1=1 AND " );
		hql.append( "WHERE firstname:=username AND " );
		
		
		TypedQuery<Employee> query = getCurrentSession().createQuery( hql.toString(), Employee.class ); 
	
		query.setParameter("username", userName);
		
		return query.getResultList().get(0);
	}


}
