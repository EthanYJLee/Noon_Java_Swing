package com.javalec.dto;

public class DtoPoint {
	private int pointno;
	private int pointcash;
	
	public DtoPoint() {
		// TODO Auto-generated constructor stub
	}

	public DtoPoint(int pointno, int pointcash) {
		super();
		this.pointno = pointno;
		this.pointcash = pointcash;
	}

	public int getPointno() {
		return pointno;
	}

	public void setPointno(int pointno) {
		this.pointno = pointno;
	}

	public int getPointcash() {
		return pointcash;
	}

	public void setPointcash(int pointcash) {
		this.pointcash = pointcash;
	}

	
}
