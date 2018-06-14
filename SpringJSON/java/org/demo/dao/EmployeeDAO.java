package org.demo.dao;

import java.util.List;

import org.demo.model.Employee;


public interface EmployeeDAO {
	public int saveorUpdate(Employee emp);
	public Employee getEmployee(int id);	
	public void delete(int id);
	public int update(Employee emp);
}
