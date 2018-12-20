package cn.tzs.demo;

import java.io.IOException;
import java.net.ServerSocket;

public class MyServer {
	//项目的根目录
	private static final String ROOT = "F:/HBuilder_project/Script_project/";
	
	public void start(){
		ServerSocket server=null;
		try {
			server= new ServerSocket(8888);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
