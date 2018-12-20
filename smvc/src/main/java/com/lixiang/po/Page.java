package com.lixiang.po;

import java.util.List;

public class Page {

	private int pageNo;

	private int pageSize;

	private int count;
	
	private int total;//总页数

	public int getTotal() {
		return (count+pageSize-1)/pageSize;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	private List<?> list;

	public Page() {
		super();
	}

	public Page(int pageNo, int pageSize, int count, List<?> list) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.count = count;
		this.list = list;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", pageSize=" + pageSize + ", count=" + count + ", total=" + total + ", list="
				+ list + "]";
	}
	
	

}
