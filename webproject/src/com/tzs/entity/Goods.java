package com.tzs.entity;

import java.io.Serializable;
import java.util.Date;

public class Goods implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;// 主键
	private String goods_code;// 商品编码
	private String name;// 商品名称
	private double price;// 商品价格
	private float discount;// 商品折扣
	private String img_url;// 图片地址
	private String goods_desc;// 商品描述
	private int status;// 商品描述，1是新建，2是上架，3是下架
	private Date create_time;// 创建时间
	private int creator_id;// 创建者id
	private Date modify_time;// 修改时间
	private int modifier_id;// 修改者id
	
	public Goods() {
		super();
	}

	public Goods(int id, String goods_code, String name, double price, float discount, String img_url,
			String goods_desc, int status, Date create_time, int creator_id, Date modify_time, int modifier_id) {
		super();
		this.id = id;
		this.goods_code = goods_code;
		this.name = name;
		this.price = price;
		this.discount = discount;
		this.img_url = img_url;
		this.goods_desc = goods_desc;
		this.status = status;
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

	public String getGoods_code() {
		return goods_code;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public float getDiscount() {
		return discount;
	}

	public String getImg_url() {
		return img_url;
	}

	public String getGoods_desc() {
		return goods_desc;
	}

	public int getStatus() {
		return status;
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

	public void setGoods_code(String goods_code) {
		this.goods_code = goods_code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public void setGoods_desc(String goods_desc) {
		this.goods_desc = goods_desc;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public void setModify_id(int modify_id) {
		this.modifier_id = modify_id;
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", goods_code=" + goods_code + ", name=" + name + ", price=" + price + ", discount="
				+ discount + ", img_url=" + img_url + ", goods_desc=" + goods_desc + ", status=" + status
				+ ", create_time=" + create_time + ", creator_id=" + creator_id + ", modify_time=" + modify_time
				+ ", modifier_id=" + modifier_id + "]";
	}

	
}
