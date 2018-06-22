package org.demo.student.dao;

import org.demo.common.ResponseObject;
import org.demo.student.dto.StudentDTO;


public interface StudentDAO {
	public ResponseObject saveStudent(StudentDTO stud);
	public ResponseObject loginStudent(StudentDTO stud);
	public ResponseObject deleteStudent(StudentDTO stud);
}
	