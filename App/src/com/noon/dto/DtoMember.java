package com.noon.dto;

public class DtoMember {
	
	// Fields
	String id;
	String pw;
	String name;
	String phone;
	String initdate;
	String updatedate;
	String deletedate;
	
	// Constructor
	public DtoMember(String id, String pw, String name, String phone, String initdate, String updatedate,
			String deletedate) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.initdate = initdate;
		this.updatedate = updatedate;
		this.deletedate = deletedate;
	}

	// Method
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getInitdate() {
		return initdate;
	}

	public void setInitdate(String initdate) {
		this.initdate = initdate;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

	public String getDeletedate() {
		return deletedate;
	}

	public void setDeletedate(String deletedate) {
		this.deletedate = deletedate;
	}
	

}
