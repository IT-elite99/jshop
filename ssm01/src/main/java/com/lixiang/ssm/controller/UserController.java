package com.lixiang.ssm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.lixiang.ssm.entity.User;
import com.lixiang.ssm.service.UserService;

@RequestMapping("/user")
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//ModelAndView-- model存放到域里面  view-->视图的名称
	@RequestMapping("/list")
	public String list(User user,Model model){
		//封装了总数，封装了分页信息，封装了查询出来的数据
		PageInfo<User> page = userService.pageList(user);
		
		model.addAttribute("page", page);
		
		return "user-list";
		
	}

}
