package com.tzs.entity;

import java.io.Serializable;
import java.util.Date;

public class Orders implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id; //主键
	private String order_no;//订单编号
	private int user_id; // 用户id
	private double total; //总价格
	private int status;//1是待支付，2是代发货，3是待收货，4是完成
	private Date create_time;//下单时间
	private Date pay_time;//支付时间
	private Date ship_time;//发货时间
	private Date recv_time;//收货时间
	
	public Orders() {
		super();
	}

	public Orders(int id, String order_no, int user_id, double total, int status, Date create_time, Date pay_time,
			Date ship_time, Date recv_time) {
		super();
		this.id = id;
		this.order_no = order_no;
		this.user_id = user_id;
		this.total = total;
		this.status = status;
		this.create_time = create_time;
		this.pay_time = pay_time;
		this.ship_time = ship_time;
		this.recv_time = recv_time;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public String getOrder_no() {
		return order_no;
	}

	public int getUser_id() {
		return user_id;
	}

	public double getTotal() {
		return total;
	}

	public int getStatus() {
		return status;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public Date getPay_time() {
		return pay_time;
	}

	public Date getShip_time() {
		return ship_time;
	}

	public Date getRecv_time() {
		return recv_time;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public void setPay_time(Date pay_time) {
		this.pay_time = pay_time;
	}

	public void setShip_time(Date ship_time) {
		this.ship_time = ship_time;
	}

	public void setRecv_time(Date recv_time) {
		this.recv_time = recv_time;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", order_no=" + order_no + ", user_id=" + user_id + ", total=" + total + ", status="
				+ status + ", create_time=" + create_time + ", pay_time=" + pay_time + ", ship_time=" + ship_time
				+ ", recv_time=" + recv_time + "]";
	}
	
	

}
