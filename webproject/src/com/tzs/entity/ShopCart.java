package com.tzs.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 购物车
 * 
 * @author Administrator
 * @date 2018-11-20
 * @location
 */
public class ShopCart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id; // 主键
	private int user_id; // 用户id
	private int goods_id; // 商品id
	private int number; // 数量
	private Date create_time; // 创建时间
	private int creator_id;// 创建者id
	private Date modify_time;// 修改时间
	private int modifier_id;// 修改者id

	public ShopCart() {
		super();
	}

	public ShopCart(int id, int user_id, int goods_id, int number, Date create_time, int creator_id, Date modify_time,
			int modifier_id) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.goods_id = goods_id;
		this.number = number;
		this.create_time = create_time;
		this.creator_id = creator_id;
		this.modify_time = modify_time;
		this.modifier_id = modifier_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public int getUser_id() {
		return user_id;
	}

	public int getGoods_id() {
		return goods_id;
	}

	public int getNumber() {
		return number;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public int getCreator_id() {
		return creator_id;
	}

	public Date getModify_time() {
		return modify_time;
	}

	public int getModifier_id() {
		return modifier_id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public void setCreator_id(int creator_id) {
		this.creator_id = creator_id;
	}

	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}

	public void setModifier_id(int modifier_id) {
		this.modifier_id = modifier_id;
	}

	@Override
	public String toString() {
		return "ShopCart [id=" + id + ", user_id=" + user_id + ", goods_id=" + goods_id + ", number=" + number
				+ ", create_time=" + create_time + ", creator_id=" + creator_id + ", modify_time=" + modify_time
				+ ", modifier_id=" + modifier_id + "]";
	}

}
