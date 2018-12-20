package com.lixiang.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lixiang.ssm.service.SecKillService;

@Controller
public class SeckillController {
	
	@Autowired
	private SecKillService service;
	
	
	@RequestMapping("seckill")
	@ResponseBody
	private String seckill(){
		String msg = service.seckill(1, 1);
		return msg;
	}
	

}
