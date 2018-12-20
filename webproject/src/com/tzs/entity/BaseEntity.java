package com.tzs.entity;

public class BaseEntity {
	// 页数，默认第一页
	private Integer pageNo = 1;
	// 每页大小，默认是20条
	private Integer pageSize = 8;

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
