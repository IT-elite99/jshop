package cn.tzs.demo;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class FirstServlet implements Servlet{
	
	private ServletConfig config;
	
	public FirstServlet() {
		System.out.println("创建对象...");
	}

	/**
	 * 销毁：1.服务器关闭的时候；
	 *     2.卸载servlet
	 */
	@Override
	public void destroy() {
		System.out.println("destroy...");
		
	}

	/**
	 * 获取servlet配置
	 */
	@Override
	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig...");
		return config;
	}

	/**
	 * 获取servlet信息
	 */
	@Override
	public String getServletInfo() {
		System.out.println("getServletInfo...");
		return "ServletInfo";
	}

	/**
	 * 初始化  客户端第一次访问才会创建config对象——>然后执行init方法
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config=config;
		System.out.println("init...");
		
		Enumeration<String> names = config.getInitParameterNames();
		System.out.println("获取所有的信息...........");
		
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			String val = config.getInitParameter(name);
			System.out.println(name+"="+val);
		}
		System.out.println("获取servlet名称："+config.getServletName());
	}

	@SuppressWarnings("unused")
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//解决乱码问题
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		System.out.println("客户端地址："+request.getRemoteHost());
		System.out.println("客户端ip地址："+request.getRemoteAddr());
		System.out.println("客户端端口："+request.getLocalPort());
		System.out.println("客户端协议："+request.getProtocol());
		System.out.println("客户端字符编码："+request.getCharacterEncoding());
		System.out.println("connect-length："+request.getContentLength());
		
		// 获取前端传过来的参数

				String name = request.getParameter("username");
				String password = request.getParameter("password");
				// 多选的情况下
				String[] insts = request.getParameterValues("inst");

				Enumeration<String> names = request.getParameterNames();
				System.out.println("获取所有的参数:------>");
				while (names.hasMoreElements()) {
					String n = names.nextElement();
					String[] vals = request.getParameterValues(n);
					System.out.println(n + "=" + Arrays.toString(vals));
				}

				// 业务

				System.out.println(response.getCharacterEncoding());
				// 响应用户，通过流想客户端输出内容


				OutputStream out = response.getOutputStream();

				out.write("<html><head><meta charset='UTF-8'></head><body><h1>这个服务器响应的内容</h1></body></html>".getBytes());
				
		
		
		
	}

}
