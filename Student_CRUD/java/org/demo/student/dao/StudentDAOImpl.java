package org.demo.student.dao;

import java.util.List;

import org.demo.common.IError;
import org.demo.common.ResponseObject;
import org.demo.student.dto.StudentDTO;
import org.demo.student.model.Student;
import org.dozer.DozerBeanMapper;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("StudentDAO")
public class StudentDAOImpl implements StudentDAO,IError  {
	
	//get the session
	@Autowired
	private SessionFactory session;
	@Autowired
	private DozerBeanMapper mapper;
	
	protected Session getSession(){
		
		return session.getCurrentSession();
	}
	//method for save the record
@Override
	public ResponseObject saveStudent(StudentDTO stud) {
	ResponseObject<String> ro=new ResponseObject<String>();
	Student student= mapper.map(stud, Student.class,"studentDTO_to_student");
		System.out.println("*********In StudentDAOImpl saveStudent()\n\n\t" +student.getStudentFname()
			+""+student.getStudentLname()+""+student.getUsername());
	int id=(Integer)getSession().save(student);
		System.out.println("*********Student Saved With ID:"+id);
		ro.setStatus("success");
		
	return ro;
	}	
@Override
public ResponseObject loginStudent(StudentDTO stud) {
	ResponseObject<String> ro=new ResponseObject<String>();
	Student student= mapper.map(stud, Student.class,"studentDTO_to_student");
		System.out.println("*********In StudentDAOImpl saveStudent()");
			String uname=student.getUsername();
			String pwd=student.getPassword();
			String status=null;
			try {
				Query selectquery=getSession().createQuery("from Student where  username=:username and password=:password");
				selectquery.setParameter("username", uname);
				selectquery.setParameter("password", pwd);
				Student s=(Student)selectquery.uniqueResult();
				if(s!=null) {
				//System.out.println("*********"+s.getUsername()+"\t"+s.getPassword());
				if(uname.equals(s.getUsername()) && pwd.equals(s.getPassword()))
				{
					status="success";
					System.out.println("*********Success");
				}
				else
				{
					status="Failure";
					System.out.println("********Failed");
				}
				}else
				{
					status="Failure";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		System.out.println("********Final Status------>"+status);
		ro.setStatus(status);
	return ro;
}

@Override
public ResponseObject deleteStudent(StudentDTO stud) {
	ResponseObject<String> ro=new ResponseObject<String>();
	Student student= mapper.map(stud, Student.class,"studentDTO_to_student");
		System.out.println("*********In StudentDAOImpl saveStudent()");
			String uname=student.getUsername();
			String pwd=student.getPassword();
			String status=null;
			try {
				Query selectquery=getSession().createQuery("delete from Student where  username=:username");
				selectquery.setParameter("username", uname);
				int count=selectquery.executeUpdate();
				if(count!=0) {
					status="success";
					System.out.println("*********Success");
				}
				else
				{
					status="Failure";
					System.out.println("********Failed");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		System.out.println("********Final Status------>"+status);
		ro.setStatus(status);
		return ro;
}
}
