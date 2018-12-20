package com.tzs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * 
 * user 查询 user?oper=toAdd 去新增 user?oper=add 新增 user?oper=del 删除
 * user?oper=batchDel 批量删除 user?oper=toUpdate 去更新 user?oper=update 更新保存
 * 
 * 所有增删该查的基类
 */
public abstract class CrudServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String OPER = "oper";
	private static final String ADD = "add";
	private static final String TO_ADD = "toAdd";
	private static final String DEL = "del";
	private static final String BATCH_DEL = "batchDel";
	private static final String TO_UPDATE = "toUpdate";
	private static final String UPDATE = "update";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CrudServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

	
		
		String oper = request.getParameter(OPER);

		if (TO_ADD.equalsIgnoreCase(oper)) {
			toAdd(request, response);
		} else if (ADD.equalsIgnoreCase(oper)) {
			add(request, response);
		} else if (DEL.equalsIgnoreCase(oper)) {
			del(request, response);
		} else if (BATCH_DEL.equalsIgnoreCase(oper)) {
			batchDel(request, response);
		} else if (TO_UPDATE.equalsIgnoreCase(oper)) {
			toUpdate(request, response);
		} else if (UPDATE.equalsIgnoreCase(oper)) {
			update(request, response);
		} else {
			list(request, response);
		}

	}

	/**
	 * 去新增
	 * 
	 * @param request
	 * @param response
	 */
	public abstract void toAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

	/**
	 * 新增保存
	 * 
	 * @param request
	 * @param response
	 */
	public abstract void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

	/**
	 * 删除
	 * 
	 * @param request
	 * @param response
	 */
	public abstract void del(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

	/**
	 * 批量删除
	 * 
	 * @param request
	 * @param response
	 */
	public abstract void batchDel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

	/**
	 * 去更新
	 * 
	 * @param request
	 * @param response
	 */
	public abstract void toUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

	/**
	 * 更新保存
	 * 
	 * @param request
	 * @param response
	 */
	public abstract void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

	/**
	 * 查询列表
	 * 
	 * @param request
	 * @param response
	 */
	public abstract void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
