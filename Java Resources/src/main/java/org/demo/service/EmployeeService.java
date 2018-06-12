package org.demo.service;

import java.util.List;

import org.demo.model.Employee;

public interface EmployeeService {
	public int saveorUpdate(Employee emp);
	public List<Employee> getEmployee();	
	public void delete(int id);
}
