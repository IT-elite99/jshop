package com.tzs.entity;

import java.io.Serializable;

/**
 * 订单详情
 * 
 * @author Administrator
 * @date 2018-11-20
 * @location
 */
public class OrderDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id; // 主键
	private int order_id; // 订单id
	private int goods_id; // 商品id
	private double price;// 商品价格
	private float discount;// 商品折扣
	private int number; // 数量
	
	public OrderDetail() {
		super();
	}

	public OrderDetail(int id, int order_id, int goods_id, double price, float discount, int number) {
		super();
		this.id = id;
		this.order_id = order_id;
		this.goods_id = goods_id;
		this.price = price;
		this.discount = discount;
		this.number = number;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public int getGoods_id() {
		return goods_id;
	}

	public double getPrice() {
		return price;
	}

	public float getDiscount() {
		return discount;
	}

	public int getNumber() {
		return number;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", order_id=" + order_id + ", goods_id=" + goods_id + ", price=" + price
				+ ", discount=" + discount + ", number=" + number + "]";
	}

	
	
}
