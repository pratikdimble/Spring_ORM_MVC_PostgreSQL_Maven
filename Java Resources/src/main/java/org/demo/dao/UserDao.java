package org.demo.dao;

import java.util.List;

import org.demo.model.User;

public interface UserDao {
	
	public List<User> getUser();	
	public void saveorUpdate(User user);
	public void delete(int id);
	public User findUserBy(int id);

}
