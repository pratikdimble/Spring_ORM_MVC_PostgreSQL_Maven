package org.demo.service;

import java.util.List;

import org.demo.dao.UserDao;
import org.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	UserDao userDao;
	
	
	public List<User> getUser() {
		
		return userDao.getUser();
	}

	public void saveorUpdate(User user) {
		userDao.saveorUpdate(user);

	}

	public void delete(int id) {
		userDao.delete(id);
	}

	public User findUserBy(int id) {
		
		return userDao.findUserBy(id);
	}

}
