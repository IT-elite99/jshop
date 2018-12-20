package com.tzs.Listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class RequestListener
 */

public class RequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("销毁一个request对象");
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("创建一个request对象");
		
	}

   
}
