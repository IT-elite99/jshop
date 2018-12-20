package com.tzs.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tzs.entity.Page;
import com.tzs.entity.User;
import com.tzs.service.UserService;
import com.tzs.util.ConvertParam;
import com.tzs.util.InstUtils;

@WebServlet("/user")
public class UserConttroller extends CrudServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserService service = new UserService();

	@Override
	public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 调到去新增的页面
		// 生产token，方重复提交业务
		String token = new Long(System.currentTimeMillis()).toString();

		request.getSession().setAttribute("token", token);
		request.setAttribute("token", token);
		//request.setAttribute("map", InstUtils.map);
	
		request.getRequestDispatcher("WEB-INF/view/user-add.jsp").forward(request, response);

	}

	@Override
	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String token1 = request.getParameter("token");
		String token2 = (String) request.getSession().getAttribute("token");

		if (token1 == null && !"".equals(token1.trim()) && !token1.equals(token2)) {

			response.sendRedirect(request.getContextPath() + "/hint.jsp");
		}
		// 处理过后，一定要把session里面的token去掉
		request.getSession().removeAttribute("token");
		
		// 封装参数，把接收到的参数转化为一个user对象
		User user = ConvertParam.convert(User.class, request);
		boolean result = service.add(user);
		// 把结果放到域里
		request.getSession().setAttribute("operResult",result);
		// 跳转到视图页面
		System.out.println("i dlosjfdjf");
		response.sendRedirect(request.getContextPath() + "/user");

	}

	@Override
	public void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 根据主键删除学生的信息
		String idStr = request.getParameter("id");
		boolean result = false;
		// id不能为空且不是空字符串
		if (idStr != null && !"".equals(idStr.trim())) {
			int id = Integer.parseInt(idStr);
			result = service.deleteById(id);
		}
		// 包操作放到会话域中
		request.getSession().setAttribute("operResult", response);
		// 跳转到视图页面
		response.sendRedirect(request.getContextPath() + "/user");

	}

	@Override
	public void batchDel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] idStrings = request.getParameterValues("id");
		int count = 0;
		if (idStrings != null && idStrings.length > 0) {
			for (String ids : idStrings) {
				// id不能为null且不能是空字符串
				if (ids != null && !"".equals(ids.trim())) {
					int id = Integer.parseInt(ids);
					boolean result = service.deleteById(id);

					if (result) {
						count++;
					}
				}
			}
		}
		request.getSession().setAttribute("operResult", count > 0);
		response.sendRedirect(request.getContextPath() + "/user");
	}

	@Override
	public void toUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 根据主键修改学生信息
		String idStr = request.getParameter("id");
		User user = null;
		// id不能为空且不是空字符串
		if (idStr != null && !"".equals(idStr.trim())) {
			
			int id = Integer.parseInt(idStr);
			user = service.queryById(id);
		}

		if (user == null) {
			// 包操作放到会话域中
			request.getSession().setAttribute("operResult", false);
			// 跳转到视图页面
			response.sendRedirect(request.getContextPath() + "/user");
		} else {
			// 真正的修改
			request.setAttribute("user", user);
			request.getRequestDispatcher("/WEB-INF/view/user-update.jsp").forward(request, response);
		}
	}

	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = ConvertParam.convert(User.class, request);

		// String[] insts = request.getParameterValues("inst");
		// if (insts != null && insts.length > 0) {
		// StringBuffer sb = new StringBuffer();
		//
		// for (String inst : insts) {
		// sb.append(inst).append(",");
		// }
		// // 1,2,
		// user.setInst(sb.toString());
		// }

		// 后台对这些还是要检查（必须）

		boolean result = service.update(user);

		// 把操作结果放到会话域中
		request.getSession().setAttribute("operResult", result);
		// 跳转到视图页面
		response.sendRedirect(request.getContextPath() + "/user");
	}

	@Override
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 封装参数
		User param = ConvertParam.convert(User.class, request);
		// 查询当前页的数据
		List<User> users = service.page(param);
		// 查询总的条目数
		int count = service.count(param);
		// 把结果放到域里a
		Page page = new Page(param.getPageNo(), param.getPageSize(), count, users);

		request.setAttribute("page", page);
		request.setAttribute("param", param);
		request.getRequestDispatcher("WEB-INF/view/user-list.jsp").forward(request, response);
	}
}
