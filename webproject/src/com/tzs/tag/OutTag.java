package com.tzs.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class OutTag extends SimpleTagSupport {
	
	private Object value;
	
	
	public Object getValue() {
		return value;
	}


	public void setValue(Object value) {
		this.value = value;
	}


	/**
	 * 真正来处理标签的
	 */
	@Override
	public void doTag() throws JspException, IOException {
	
		//获取输出流
		getJspContext().getOut().write(value.toString());
		
		
	}
	
	
	

}
