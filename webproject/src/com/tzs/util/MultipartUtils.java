package com.tzs.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;


public class MultipartUtils {

	private boolean isMultipart = false;

	// 文件
	private List<FileItem> files = new ArrayList<>();
	// 普通的参数
	private Map<String, String[]> params = new HashMap<>();

	public MultipartUtils(HttpServletRequest request) {
		prase(request);
	}

	public boolean isMultipart() {
		return isMultipart;
	}

	public List<FileItem> getFiles() {
		return files;
	}

	public Map<String, String[]> getParams() {
		return params;
	}

	public void prase(HttpServletRequest request) {

		isMultipart = ServletFileUpload.isMultipartContent(request);

		if (!isMultipart) {
			params = request.getParameterMap();
			return;
		}

		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// Configure a repository (to ensure a secure temp location is used)
		ServletContext servletContext = request.getServletContext();

		// repository 仓库 文件夹用来存放上传的文件
		File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");

		factory.setRepository(repository);

		// Create a new file upload handler 创建一个文件上传的处理类
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		// Parse the request
		try {
			// 使用这个处理类来解析请求信息

			// 把每一个文件或者是普通文本解析成一个一个的FileItem
			List<FileItem> items = upload.parseRequest((RequestContext) request);

			// 处理文件或者文本--->FileItem

			if (items != null && !items.isEmpty()) {
				// 遍历
				for (FileItem item : items) {

					// 判断是否一个普通的字段
					/**
					 * inst=1--->inst:[1] inst=2-->inst:[1,2]
					 * 
					 * 
					 * 
					 */
					if (item.isFormField()) {
						String name = item.getFieldName();
						String value = item.getString("utf-8");

						if (params.containsKey(name)) {
							String[] oldValues = params.get(name);
							String[] newValues = Arrays.copyOf(oldValues, oldValues.length + 1);
							newValues[newValues.length - 1] = value;
							params.put(name, newValues);

						} else {
							params.put(name, new String[] { value });
						}

					} else {// 如果不是hi普通的字段拿应该是一个文件
						files.add(item);
					}

				}
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

}
