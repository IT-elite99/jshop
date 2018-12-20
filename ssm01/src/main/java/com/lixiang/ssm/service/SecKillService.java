package com.lixiang.ssm.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lixiang.ssm.dao.SeckillMapper;
import com.lixiang.ssm.entity.Seckill;

@Service
public class SecKillService {

	@Autowired
	private SeckillMapper mapper;

	
	public String startSeckill(int id, int num) {
		Seckill sec = mapper.selectByPrimaryKey(id);

		try {
			Thread.currentThread().sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (sec == null || sec.getStatus() != 1) {
			return "没有这个秒杀活动!";
		}

		Date now = new Date();

		if (now.before(sec.getStartDate())) {
			return "秒杀活动还没开始..";
		}

		if (now.after(sec.getEndDate()))

		{
			return "秒杀活动已经结束..";
		}
		
		//判断是开启秒杀，
		
		//set seckill:1  过期时间-2个小时 消失，在存号 set 100个
		
		//去获取号
		
		
		
		//异步的方式去处理这个任务
		
		// 真真的去参与秒杀
		return seckill(id, num);
	}

	/**
	 * 真真的去秒杀
	 * 
	 * @param id
	 * @return
	 */

	@Transactional
	public String seckill(int id, int num) {

		// 判断库存是否足够,减库存--防止超卖
		boolean flag = mapper.subStock(id, num);

		if (flag) {
			// 生产订单...
		}
		
		
		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (flag) {
			String name = Thread.currentThread().getName();
			return name+"--秒杀成功....";
		} else {
			return "秒杀失败....";
		}

	}

}
