package org.demo.student.service;

import org.demo.common.ResponseObject;
import org.demo.student.dao.StudentDAO;
import org.demo.student.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentDAO studdao;

	@Override
	public ResponseObject saveStudent(StudentDTO stud) {
	ResponseObject ro=new ResponseObject();
	System.out.println("*********In StudentService saveStudent()");
		ro=studdao.saveStudent(stud);
		return ro;
	}
@Override
public ResponseObject loginStudent(StudentDTO stud) {
	ResponseObject ro=new ResponseObject();
	System.out.println("*********In StudentService loginStudent()");
		ro=studdao.loginStudent(stud);
		return ro;
}

@Override
public ResponseObject deleteStudent(StudentDTO stud) {
	ResponseObject ro=new ResponseObject();
	System.out.println("*********In StudentService deleteStudent()");
		ro=studdao.deleteStudent(stud);
		return ro;
}
}
