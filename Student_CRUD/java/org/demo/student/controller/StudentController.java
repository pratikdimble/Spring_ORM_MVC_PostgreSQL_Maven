package org.demo.student.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.demo.common.ResponseObject;
import org.demo.student.dto.StudentDTO;
import org.demo.student.service.StudentService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
//@RestController
@SuppressWarnings({ "rawtypes", "unchecked" })
public class StudentController {

	
	@Autowired
	StudentService studentService;

	@RequestMapping(value="/")
	public String landing(HttpServletRequest req,HttpServletResponse res){
		return "/firstpage";
	}//landing() close

	@RequestMapping(value="/add" ,method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseObject<String> saveStudent(@RequestBody String stud){
		System.out.println("*********In StudentController saveStudent()");
		System.out.println(stud);
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES);
		StudentDTO studObj=new StudentDTO();
		try {
			studObj = mapper.readValue(stud,StudentDTO.class);
			
			System.out.println(studObj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseObject response=studentService.saveStudent(studObj);
		JSONObject json=new JSONObject(response);
		System.out.println("From Controller------>"+json);
		return response;
	}//saveStudent() close
	
	@RequestMapping(value="/login" ,method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseObject<String> loginStudent(@RequestBody String stud){
		System.out.println("*********In StudentController loginStudent()");
		System.out.println(stud);
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES);
		StudentDTO studObj=new StudentDTO();
		try {
			studObj = mapper.readValue(stud,StudentDTO.class);
			
			System.out.println(studObj);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseObject response=studentService.loginStudent(studObj);
		JSONObject json=new JSONObject(response);
		System.out.println(""+json);
		return response;
	}//loginStudent() close
	
	@RequestMapping(value="/delete" ,method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseObject<String> deleteStudent(@RequestBody String stud){
		System.out.println("*********In StudentController deleteStudent()");
		System.out.println(stud);
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES);
		StudentDTO studObj=new StudentDTO();
		try {
			studObj = mapper.readValue(stud,StudentDTO.class);
			
			System.out.println(studObj);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseObject response=studentService.deleteStudent(studObj);
		JSONObject json=new JSONObject(response);
		System.out.println(""+json);
		return response;
	}//deleteStudent() close
}
