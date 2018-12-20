package com.tzs.entity;

import java.io.Serializable;
import java.util.Date;

public class Student extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//学生ID,主键
	private Integer id;
	//学生姓名
	private String name;
	//学生的登录密码
	private String password;
	//性别
	private Integer sex;
	//学生出生日期
	private Date birthday;
	//兴趣爱好
	private String interest;
	//自我介绍
	private String self_introduction;
	
	//开始时间
	private Date startDate;
	//结束时间
	private Date endDate;
	

	public Student() {
		super();
	}


	public Student(Integer id, String name, String password,Integer sex, Date birthday, String interest, String self_introduction) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.birthday = birthday;
		this.interest = interest;
		this.self_introduction = self_introduction;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public String getInterest() {
		return interest;
	}


	public void setInterest(String interest) {
		this.interest = interest;
	}


	public String getSelf_introduction() {
		return self_introduction;
	}


	public void setSelf_introduction(String self_introduction) {
		this.self_introduction = self_introduction;
	}
	
	


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", password=" + password + ", birthday=" + birthday
				+ ", interest=" + interest + ", self_introduction=" + self_introduction + "]";
	}



	
	

}
