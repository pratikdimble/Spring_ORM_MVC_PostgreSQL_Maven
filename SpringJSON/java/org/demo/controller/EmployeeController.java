package org.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.demo.model.Employee;
import org.demo.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class EmployeeController {
	@Autowired
	EmployeeService empService;

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	
		//Map to store employees, ideally we should use database
		Map<Integer, Employee> empData = new HashMap<Integer, Employee>();
		
		@RequestMapping(value="/")
		public String landing(HttpServletRequest req,HttpServletResponse res){
			return "/register";
		}//landing() close
		
		
		@RequestMapping(value = EmpRestURIConstants.DUMMY_EMP, method = RequestMethod.GET)
		public @ResponseBody Employee getDummyEmployee() {
			logger.info("Start getDummyEmployee");
			Employee emp = new Employee();
			emp.setId(9999);
			emp.setName("Dummy Pratik");
			emp.setCreatedDate(new Date());
			empData.put(9999, emp);
			return emp;
		}
		
		@RequestMapping(value ="/rest/emp/{id}", method = RequestMethod.GET)
		public @ResponseBody Employee getEmployee( @PathVariable("id") int empId){
			logger.info("Start getEmployee. ID="+empId);
			
			System.out.println("\t*******"+empId);
			Employee emp=empService.getEmployee(empId);
			return emp;
		}
		
		@RequestMapping(value = EmpRestURIConstants.GET_ALL_EMP, method = RequestMethod.GET)
		public @ResponseBody List<Employee> getAllEmployees() {
			logger.info("Start getAllEmployees.");
			List<Employee> emps =empService.getAllEmployee();
			return emps;
		}
		
		@RequestMapping(value = EmpRestURIConstants.CREATE_EMP, method = RequestMethod.POST)
		public @ResponseBody Employee createEmployee(@RequestBody Employee emp) {
			logger.info("Start createEmployee.");
			emp.setCreatedDate(new Date());
			System.out.println("\t*******"+emp.getId()+"\t"+emp.getName());
			int id=empService.saveorUpdate(emp);
			return emp;
		}
		
		@RequestMapping(value = "/rest/emp/delete/{id}", method = RequestMethod.DELETE)
		public @ResponseBody int deleteEmployee(@PathVariable("id") int empId) {
			logger.info("Start deleteEmployee.");
			empService.delete(empId);
			return empId;
		}
		@RequestMapping(value = "/rest/emp/update", method = RequestMethod.PUT)
		public @ResponseBody int updateEmployee(@RequestBody Employee emp) {
			logger.info("Start updateEmployee.");
			empService.update(emp);
			return emp.getId();
		}


	@RequestMapping(value="register", method = RequestMethod.POST)
	   public ModelAndView showData(HttpServletRequest req,HttpServletResponse res){
		   //get the parameter values and parse if needed
		   String name=req.getParameter("name");
		   String password=req.getParameter("password");
		   long contactNumber=Long.parseLong(req.getParameter("contact")); 
		   /*Employee emp=new Employee();
			emp.setUserName(name);emp.setContactNumber(contactNumber);emp.setPassword(password);
			int id=empService.saveorUpdate(emp);*/
		   String msg=null;
		   		if(name.equals("pratik"))
		   			msg="Success";
		   		else
		   			msg="Fail";
			ModelAndView mv=new ModelAndView();
			mv.setViewName("register");
			mv.addObject("id",msg);
			return mv;
		}//showData() ends
	/*
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public ModelAndView user(){		
		ModelAndView model=new ModelAndView("/newuser");
		List<Employee> emps = empService.getEmployee();
		model.addObject("emps", emps);
		return model;		
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable ("id") int id){
		
		empService.delete(id);
		return new ModelAndView("redirect:/show");

	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(){		
		ModelAndView model=new ModelAndView("/login_form");
		Employee emp=new Employee();
		model.addObject("userForm",emp);
		return model;		
	}*/
	/*@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveEmp(@ModelAttribute("userForm") Employee emp){
		
		empService.saveorUpdate(emp);
		return new ModelAndView("redirect:/newuser");
	}
	*/
/*	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ModelAndView user(){		
		ModelAndView model=new ModelAndView("/user");
		List<User> users = userService.getUser();
		model.addObject("users", users);
		return model;		
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(){		
		ModelAndView model=new ModelAndView("/form");
		User user=new User();
		model.addObject("userForm",user);
		return model;		
	}
*/
	
	/*@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("userForm") User user){
		
		userService.saveorUpdate(user);
		return new ModelAndView("redirect:/user");
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable ("id") int id){
		ModelAndView model=new ModelAndView("/form");
		User user = userService.findUserBy(id);
		model.addObject("userForm",user);
		return model;		

	}
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable ("id") int id){
		
		userService.delete(id);
		return new ModelAndView("redirect:/user");

	}*/



}
