package com.noon.dto;

public class DtoStaff {
	private String filepath;
	private String id;
	private String pw;
	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

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
	
	public DtoStaff(String filepath, String id, String pw, String phone) {
		super();
		this.filepath = filepath;
		this.id = id;
		this.pw = pw;
		this.phone = phone;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
}
