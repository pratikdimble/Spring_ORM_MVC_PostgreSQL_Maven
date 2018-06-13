package org.demo.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_data")
public class Employee implements Serializable{
	
	private int userId;
	private String userName;
	private String password;
	private long contactNumber;
	
	
	
	public Employee() {
		super();
		System.out.println("*****You are in User Model");
	}

	public Employee(int userId, String userName, String password, long contactNumber) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.contactNumber = contactNumber;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Column(unique=true)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
