package com.tzs.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.tomcat.util.http.fileupload.FileItem;

import com.tzs.entity.User;
import com.tzs.service.UserService;
import com.tzs.util.MultipartUtils;

/**
 * Servlet implementation class UpLoadUserController
 */
@WebServlet("/uploadUser")
public class UpLoadUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Logger logger = Logger.getLogger(UpLoadUserController.class);
	private UserService service = new UserService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpLoadUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收上传文件
		MultipartUtils utils = new MultipartUtils(request);
		List<FileItem> files = utils.getFiles();
		int total = 0;
		int success =0;
		//判断文件
		if (files != null && files.size()>0 ) {
			FileItem file =files.get(0);
			// 2.把上传的文件当做execl来处理
			NPOIFSFileSystem fs = new NPOIFSFileSystem(file.getInputStream());
			//HSSFWorkbook --描述的就是一个execl对象
			HSSFWorkbook wb = new HSSFWorkbook(fs.getRoot(), true);
			//获取sheet页
			Sheet sheet = wb.getSheetAt(0);
			
			//获取这个sheet页一共有多少条数据
			int count = sheet.getLastRowNum();
			logger.debug("execl 总共有多少 "+count+"条数据");
			
			//遍历数据
			for(int i=1;i<=count;i++){
				//row 描述的是一行数据
				Row row = sheet.getRow(i);
				// cell 描述的单元格
				Cell cell1 = row.getCell(1);
				String real_name = cell1.getStringCellValue();
				
				Cell cell2 = row.getCell(2);
				String password = cell2.getStringCellValue();
				
				Cell cell3 = row.getCell(3);
				String sexStr = cell3.getStringCellValue();
				
				int sex = "男".equals(sexStr)?1:0;
				
				Cell cell4 = row.getCell(4);
				String address = cell4.getStringCellValue();
				
				Cell cell5 = row.getCell(5);
				Date birthday = cell5.getDateCellValue();
				
				User user = new User(null,real_name,password,sex,address,birthday);
						
				user.setSex(sex);
				total++;
				// 3.把对象存放数据库里面去
				boolean result = service.add(user);
				if(result){
					success++;
				}
				
			}

		}
		// 4.响应客户 json
		response.getWriter().write("{total:"+total+",success:"+success+"}");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
