package cn.stu.test;

import org.dom4j.DocumentException;
import org.jaxen.expr.AdditiveExpr;

import cn.stu.dao.Student;
import cn.stu.service.StuService;

public class TestStudent {
	public static void  testAdd() throws Exception {
		//设置值
		Student student = new Student();
		student.setId("103");
		student.setName("tangsan");
		student.setAge("15");
		StuService.add(student);
	}
	
	public static void testDelById(){
		StuService.delById("103");
		System.out.println("删除成功");
	}
	
	
	public static void main(String[] args) throws Exception {
		//testAdd();
		testDelById();
	}

}
