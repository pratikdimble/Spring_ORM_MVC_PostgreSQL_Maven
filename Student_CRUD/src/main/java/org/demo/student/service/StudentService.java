package org.demo.student.service;

import org.demo.common.ResponseObject;
import org.demo.student.dto.StudentDTO;


public interface StudentService {
	public ResponseObject saveStudent(StudentDTO stud);
	public ResponseObject loginStudent(StudentDTO stud);
	public ResponseObject deleteStudent(StudentDTO stud);
}
	