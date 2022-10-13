package com.noon.dto;

public class DtoOrder {
	String paydate;
	String menuname;
	int sum_quantity;
	int count_orderno;
	int count_completetime;

	int customerno;
	// 대기번호
	int orderno;
	// 주문번ㅎ호
	int quantity;
	// ㅈ 주문개수
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

	public DtoOrder(String paydate, String menuname, int sum_quantity, int count_orderno, int count_completetime) {
		this.paydate = paydate;
		this.menuname = menuname;
		this.sum_quantity = sum_quantity;
		this.count_completetime = count_completetime;
		this.count_orderno = count_orderno;
	}

	public String getPaydate() {
		return paydate;
	}

	public void setPaydate(String paydate) {
		this.paydate = paydate;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public int getSum_quantity() {
		return sum_quantity;
	}

	public void setSum_quantity(int sum_quantity) {
		this.sum_quantity = sum_quantity;
	}

	public int getCount_orderno() {
		return count_orderno;
	}

	public void setCount_orderno(int count_orderno) {
		this.count_orderno = count_orderno;
	}

	public int getCount_completetime() {
		return count_completetime;
	}

	public void setCount_completetime(int count_completetime) {
		this.count_completetime = count_completetime;
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
