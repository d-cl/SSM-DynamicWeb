package com.offcn.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.offcn.ssm.bean.User;
import com.offcn.ssm.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/toAdd")
	public String toAdd(){
		return "add";
	}
	
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public String addUser(User user){
		userService.addUser(user);
		return "redirect:/index.jsp";
	}
	
	@RequestMapping(value="/delUserById/{id}",method=RequestMethod.DELETE)
	public String delUserById(@PathVariable("id") Integer id){
		userService.delUserById(id);
		return "redirect:/index.jsp";
	}
	
	@RequestMapping(value="/upd/{id}")
	public ModelAndView upd(@PathVariable("id") Integer id){
		User user = userService.findUserById(id);
		ModelAndView mv=new ModelAndView("upd");
		mv.addObject("user", user);
		return mv;
	}
	
	@RequestMapping(value="/updateUser",method=RequestMethod.PUT)
	public String updateUser(User user){
		userService.updateUser(user);
		return "redirect:/index.jsp";
	}
	
	@RequestMapping(value="/findUsers",method=RequestMethod.GET)
	public ModelAndView findUser(){
		ModelAndView mv=new ModelAndView("index");
		List<User> users = userService.findUser();
		mv.addObject("users", users);
		return mv;
	}
	
}
