package org.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.demo.model.Employee;
import org.demo.model.User;
import org.demo.service.EmployeeService;
import org.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	@Autowired
	EmployeeService empService;

	@RequestMapping(value="/")
	public String landing(HttpServletRequest req,HttpServletResponse res){
		return "/register";
	}//landing() close
	@RequestMapping(value="register", method = RequestMethod.POST)
	   public ModelAndView showData(HttpServletRequest req,HttpServletResponse res){
		   //get the parameter values and parse if needed
		   String name=req.getParameter("name");
		   String password=req.getParameter("password");
		   long contactNumber=Long.parseLong(req.getParameter("contact")); 
		   Employee emp=new Employee();
			emp.setUserName(name);emp.setContactNumber(contactNumber);emp.setPassword(password);
			int id=empService.saveorUpdate(emp);
			ModelAndView mv=new ModelAndView();
			mv.setViewName("display");
			mv.addObject("id",id);
			return mv;
		}//showData() ends
	
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
		/*Employee emp=new Employee();
		model.addObject("userForm",emp);*/
		return model;		
	}
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
