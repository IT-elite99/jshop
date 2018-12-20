package cn.stu.service;



import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import cn.stu.dao.Student;

public class StuService {
	
	//增加
	public static void add(Student student) throws DocumentException {
		//1.创建解析器
		SAXReader saxReader = new SAXReader();
		//2.得到document
		Document document = saxReader.read("config/student.xml");
		//3.得到根节点
		Element root = document.getRootElement();
		//在根节点上添加student
		Element stu = root.addElement("stu");
		//在stu标签上依次添加属性
		Element id1 = stu.addElement("id");
		Element name1 = stu.addElement("name");
		Element age1 = stu.addElement("age");
		//在属性上依次添加值
		id1.setText(student.getId());
		name1.setText(student.getName());
		age1.setText(student.getAge());
		//回写xml
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter = null;
		try {
			xmlWriter = new XMLWriter(new FileOutputStream("config/student.xml"), format);
			xmlWriter.write(document);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				xmlWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	//删除
	public static void delById(String id){
		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read("config/student.xml");
			//获取所有id属性
			List<Node> list = document.selectNodes("//id");
			//遍历list集合
			for (Node node : list) {
				String idvalue= node.getText();
				//判断idvalue和id是否相同
				if (idvalue.equals(id)) {
					//得到stu节点
					Element stu = node.getParent();
					//获取stu的父节点
					Element student = stu.getParent();
					//根据父节点删除stu
					student.remove(stu);
				}
			}
			//回写
			OutputFormat format = OutputFormat.createPrettyPrint();
			XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("config/student.xml"), format);
			xmlWriter.write(document);
			xmlWriter.close();
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

}
