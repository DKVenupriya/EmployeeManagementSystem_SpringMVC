package com.jsp.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.DTO.Employee;

@Repository
public class EmployeeDao {
	
	@Autowired
	EntityManager manager;
	
	@Autowired
	EntityTransaction transaction;
	
	
	//To insert employee object to DB
	public void saveEmployee(Employee employee)
	{
		transaction.begin();
		manager.persist(employee);
		transaction.commit();
	}
	

	//To find employee based on ID
	public Employee getEmployeeById(int id)
	{
		Employee e = manager.find(Employee.class, id);
		return e;
	}
	
	
	//To remove employee based on id
	public void deleteEmployee(int id)
	{
		Employee e = manager.find(Employee.class, id);
		if(e != null)
		{
			transaction.begin();
			manager.remove(e);
			transaction.commit();
		}
	}
	
	//To Update Employee Details 
	public void updateEmployee(Employee updatedEmployee)
	{
		transaction.begin();
		manager.merge(updatedEmployee);
		transaction.commit();
	}
	
	
	//To get all the Employee Details
	public List<Employee> getAllEmployee(){
		
		Query q = manager.createQuery("select e from Employee e");
		
		List<Employee> employees = q.getResultList();
		return employees;
		
	}
}

