package org.demo.dao;

import java.util.List;

import org.demo.model.Employee;


public interface EmployeeDAO {
	public int saveorUpdate(Employee emp);
	public List<Employee> getEmployee();	
	public void delete(int id);
}
