package org.demo.service;

import java.util.List;

import org.demo.model.Employee;

public interface EmployeeService {
	public int saveorUpdate(Employee emp);
	public int update(Employee emp);
	public Employee getEmployee(int empId);	
	public void delete(int id);
}
