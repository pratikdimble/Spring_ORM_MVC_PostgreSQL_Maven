package org.demo.dao;

import java.util.List;

import org.demo.model.Employee;
import org.demo.model.User;
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
		return emp.getUserId();
	}

//method for retrive the data
@Override
public List<Employee> getEmployee() {
	Criteria criteria=getSession().createCriteria(Employee.class);
	return (List<Employee>) criteria.list();
	}

	//method for delete the record
@Override
public void delete(int id) {
	Employee emp=getSession().get(Employee.class,id);
	getSession().delete(emp);
	}
}
