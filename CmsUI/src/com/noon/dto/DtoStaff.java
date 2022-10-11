package com.noon.dto;

public class DtoStaff {
	private String id;
	private String name;
	private String phone;
	private int count;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public DtoStaff(String id, String name, String phone, int count) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.count = count;
	}
}
