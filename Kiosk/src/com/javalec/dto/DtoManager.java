package com.javalec.dto;

public class DtoManager {
	private String id;
	private String pw;
	private String name;
	private int employeeno;
	
	public DtoManager() {
		// TODO Auto-generated constructor stub
	}

	public DtoManager(String id, String pw, String name, int employeeno) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.employeeno = employeeno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmployeeno() {
		return employeeno;
	}

	public void setEmployeeno(int employeeno) {
		this.employeeno = employeeno;
	}

}
