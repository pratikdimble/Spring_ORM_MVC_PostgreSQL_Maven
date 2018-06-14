package org.demo.dao;

import java.util.List;

import org.demo.model.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository("EmployeeDao")
public class EmployeeDAOImpl implements EmployeeDAO {
	
	//get the session
	@Autowired
	private SessionFactory session;
	
	protected Session getSession(){
		
		return session.getCurrentSession();
	}
	//method for save the record
@Override
	public int saveorUpdate(Employee emp) {
		getSession().saveOrUpdate(emp);
		return emp.getId();
	}

//method for retrive the data
@Override
public Employee getEmployee(int id) {
	Employee emp=(Employee) getSession().get(Employee.class,id);
	System.out.println("\t***From Get");
	return emp;
}
	//method for delete the record
@Override
public void delete(int id) {
	Employee emp=getSession().get(Employee.class,id);
	getSession().delete(emp);
	}
@Override
public int update(Employee emp) {
	
	Employee e=(Employee) getSession().get(Employee.class, emp.getId());
	e.setName(emp.getName());
	System.out.println(emp.getName());
		//getSession().update(e);
	return e.getId();
	}

//Get All Data
@Override
public List<Employee> getAllEmployee() {
	
	Criteria criteria = getSession().createCriteria(Employee.class);
	List employees = criteria.list();
	return employees;
}
}
