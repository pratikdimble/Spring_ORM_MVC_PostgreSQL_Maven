package org.demo.dao;

import java.util.List;

import org.demo.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession(){
		
		return sessionFactory.getCurrentSession();
	}

	public List<User> getUser() {
		Criteria criteria = getSession().createCriteria(User.class);
		return (List<User>)  criteria.list();
	}

	public void saveorUpdate(User user) {
		getSession().saveOrUpdate(user);
	}

	public void delete(int id) {
		User user = (User) getSession().get(User.class, id);
		getSession().delete(user);

	}

	public User findUserBy(int id) {
		
		return (User) getSession().get(User.class, id);
	}

}
