package cn.tzs.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 主键
	private Integer id;
	// 姓名
	private String name;
	// 密码
	private String password;
	// 出生年月
	private Date birthday;
	
	
	// 开始时间
	private Date startDate;
	// 结束时间
	private Date endDate;
	
	

	public User() {
		super();
	}

	public User(Integer id, String name, String password, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.birthday = birthday;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", birthday=" + birthday + "]";
	}

}
