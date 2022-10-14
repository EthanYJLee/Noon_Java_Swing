package com.noon.dto;

public class DtoPoint {

	// Fields
	int pointno;
	String pointdate;
	int pointcash;
	String member_id;
	
	// Constructor
	public DtoPoint() {
		// TODO Auto-generated constructor stub
	}

	public DtoPoint(int pointno, String pointdate, int pointcash, String member_id) {
		super();
		this.pointno = pointno;
		this.pointdate = pointdate;
		this.pointcash = pointcash;
		this.member_id = member_id;
	}

	public int getPointno() {
		return pointno;
	}

	public void setPointno(int pointno) {
		this.pointno = pointno;
	}

	public String getPointdate() {
		return pointdate;
	}

	public void setPointdate(String pointdate) {
		this.pointdate = pointdate;
	}

	public int getPointcash() {
		return pointcash;
	}

	public void setPointcash(int pointcash) {
		this.pointcash = pointcash;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	
	
}
