package com.noon.dto;

public class DtoOrder {
	
	int customerno;
	//대기번호
	int orderno;
	//주문번ㅎ호
	int quantity;
	//ㅈ 주문개수
	String name;
//	// 메뉴 이
	String ordertime;
//	// 주문시간
	String completetime;
	
	
	public DtoOrder() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	


	public DtoOrder(String completetime) {
		super();
		this.completetime = completetime;
	}








	public DtoOrder(int customerno, int orderno, int quantity, String name, String ordertime) {
		super();
		this.customerno = customerno;
		this.orderno = orderno;
		this.quantity = quantity;
		this.name = name;
		this.ordertime = ordertime;
	}
	

	public DtoOrder(int customerno, int orderno, int quantity, String name, String ordertime, String completetime) {
		super();
		this.customerno = customerno;
		this.orderno = orderno;
		this.quantity = quantity;
		this.name = name;
		this.ordertime = ordertime;
		this.completetime = completetime;
	}








	public int getCustomerno() {
		return customerno;
	}


	public void setCustomerno(int customerno) {
		this.customerno = customerno;
	}


	public int getOrderno() {
		return orderno;
	}


	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getOrdertime() {
		return ordertime;
	}


	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}


	public String getCompletetime() {
		return completetime;
	}


	public void setCompletetime(String completetime) {
		this.completetime = completetime;
	}
	
	
	
	
	

}
