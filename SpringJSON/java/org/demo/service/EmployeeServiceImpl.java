package org.demo.service;

import java.util.List;

import org.demo.dao.EmployeeDAO;
import org.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDAO empdao;
	@Override
	public int saveorUpdate(Employee emp) {
	
		empdao.saveorUpdate(emp);
		return emp.getId();
	}
/*@Override
public List<Employee> getEmployee() {
	return empdao.getEmployee();
}*/

@Override
public void delete(int id) {
		empdao.delete(id);
	}
@Override
public int update(Employee emp) {
		empdao.update(emp);
	return emp.getId();
}
@Override
public Employee getEmployee(int empId) {
	return empdao.getEmployee(empId);
}

}
