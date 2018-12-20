package com.lixiang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lixiang.po.Page;
import com.lixiang.po.User;
import com.lixiang.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/user-list")
	public String list(User user, Model model) {
		List<User> list = userService.page(user);
		int count = userService.count(user);

		Page page = new Page(user.getPageNo(), user.getPageSize(), count, list);

		model.addAttribute("page", page);

		return "/user/user-list";

	}

}
