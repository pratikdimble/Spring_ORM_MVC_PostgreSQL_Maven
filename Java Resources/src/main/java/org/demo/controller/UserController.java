package org.demo.controller;

import java.util.List;

import org.demo.model.User;
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
	UserService userService;
	
	
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
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

	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
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

	}



}
