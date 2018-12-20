package com.lixiang.ssm;

import java.util.concurrent.CountDownLatch;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lixiang.ssm.entity.Seckill;
import com.lixiang.ssm.service.SecKillService;

public class TestSecKill {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

		SecKillService service = context.getBean(SecKillService.class);

		// 多线程的方式，模拟多个人去参与秒杀
		
		CountDownLatch cd = new CountDownLatch(10000);

		System.out.println("开始去参与秒杀..........");
		for (int i = 0; i < 20000; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
				    cd.countDown();
				    try {
						cd.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				    System.out.println(Thread.currentThread().getName()+" 开始去秒杀...");
					System.out.println(service.startSeckill(1, 1));

				}
			},"用户-"+i).start();
		}

	}

}
