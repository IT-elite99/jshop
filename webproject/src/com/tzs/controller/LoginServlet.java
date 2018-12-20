package com.tzs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tzs.entity.User;
import com.tzs.service.UserService;


/**
 * 登陆的控制器
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private UserService service = new UserService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收前端传过来的用户名和密码
		String name = request.getParameter("real_name");
		String password = request.getParameter("password");

		String message = null;//原因

		if (name == null || "".equals(name.trim()) || password == null || "".equals(password.trim())) {
			message = "用户名或密码不能为空";
		}

		// 参数校验
		User user = null;
		if (message == null) {
			user = service.getByName(name);
			if (user == null) {
				message = "账号错误...";
			} else if (!password.equals(user.getPassword())) {
				message = "密码错误...";
			}
		}

		if (message == null) {// 登陆成功
			// 把登陆这信息存放session中
			request.getSession().setAttribute("loginUser", user);
			// 跳到用户查询页面
			response.sendRedirect(request.getContextPath() + "/user");
		} else {// 登陆失败
			
			//想办法把不成功的原因通知给用户
			request.setAttribute("message", message);
			//重写输入，再登陆
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
