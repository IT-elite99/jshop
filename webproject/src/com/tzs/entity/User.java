package com.tzs.entity;

import java.io.Serializable;
import java.util.Date;

public class User extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 主键id
	private Integer id;
	// 账号
	private String account;
	// 真实的姓名
	private String real_name;
	// 密码
	private String password;
	// 性别
	private Integer sex;
	// 地址
	private String address;
	// 余额
	private Double balance;
	// 角色，管理员或普通用户
	private Integer role;
	// 邮箱
	private String email;
	// 注册时间
	private Date register_time;
	// 登录时间
	private Date login_time;
	// 修改时间
	private Date update_time;
	// 错误次数
	private Integer error_count;

	// 出生日期
	private Date birthday;

	public User(Integer id, String real_name, String password, Date birthday) {
		super();
		this.id = id;
		this.real_name = real_name;
		this.password = password;
		this.birthday = birthday;
	}
	public User(Integer id, String account, String real_name, String password, Integer sex, String address,
			Double balance, Integer role, String email, Date register_time, Date login_time, Date update_time,
			Integer error_count) {
		super();
		this.id = id;
		this.account = account;
		this.real_name = real_name;
		this.password = password;
		this.sex = sex;
		this.address = address;
		this.balance = balance;
		this.role = role;
		this.email = email;
		this.register_time = register_time;
		this.login_time = login_time;
		this.update_time = update_time;
		this.error_count = error_count;
	}

	public User(Date birthday) {
		super();
		this.birthday = birthday;
	}

	public User(Object object, String real_name2, String password2, int sex2, String address2, Date birthday2) {
		// TODO Auto-generated constructor stub
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public String getAccount() {
		return account;
	}

	public String getReal_name() {
		return real_name;
	}

	public Integer getSex() {
		return sex;
	}

	public String getAddress() {
		return address;
	}

	public Double getBalance() {
		return balance;
	}

	public Integer getRole() {
		return role;
	}

	public String getEmail() {
		return email;
	}

	public Date getRegister_time() {
		return register_time;
	}

	public Date getLogin_time() {
		return login_time;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public Integer getError_count() {
		return error_count;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setRegister_time(Date register_time) {
		this.register_time = register_time;
	}

	public void setLogin_time(Date login_time) {
		this.login_time = login_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public void setError_count(Integer error_count) {
		this.error_count = error_count;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", account=" + account + ", real_name=" + real_name + ", password=" + password
				+ ", sex=" + sex + ", address=" + address + ", balance=" + balance + ", role=" + role + ", email="
				+ email + ", register_time=" + register_time + ", login_time=" + login_time + ", update_time="
				+ update_time + ", error_count=" + error_count + ", birthday=" + birthday + "]";
	}

}
