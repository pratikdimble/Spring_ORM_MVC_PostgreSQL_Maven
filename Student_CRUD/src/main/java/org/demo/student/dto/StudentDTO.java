package org.demo.student.dto;

public class StudentDTO {
	private int studentId;
	private String studentFname;
	private String studentLname;
	private String username;
	private String password;
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
	public StudentDTO(int studentId, String studentFname, String studentLname, String username, String password) {
		super();
		this.studentId = studentId;
		this.studentFname = studentFname;
		this.studentLname = studentLname;
		this.username = username;
		this.password = password;
	}
	public StudentDTO() {
		super();
		System.out.println("*********In StudentDTO");
	}
	
	
}
