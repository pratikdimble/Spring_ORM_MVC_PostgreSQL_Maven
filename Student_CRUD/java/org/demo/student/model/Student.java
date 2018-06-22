package org.demo.student.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student implements Serializable{
	
private int studentId;
private String studentFname;
private String studentLname;
private String username;
private String password;

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
public int getStudentId() {
	return studentId;
}
public void setStudentId(int studentId) {
	this.studentId = studentId;
}
public String getStudentFname() {
	return studentFname;
}
public void setStudentFname(String studentFname) {
	this.studentFname = studentFname;
}
public String getStudentLname() {
	return studentLname;
}
public void setStudentLname(String studentLname) {
	this.studentLname = studentLname;
}

@Column(unique=true)
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Student(int studentId, String studentFname, String studentLname, String username, String password) {
	super();
	this.studentId = studentId;
	this.studentFname = studentFname;
	this.studentLname = studentLname;
	this.username = username;
	this.password = password;
}
public Student() {
	super();
	System.out.println("**********In Student Entity");
	}
}
