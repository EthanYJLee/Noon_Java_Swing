package com.noon.dto;

public class DtoOrder {

	int customerno;
	// 대기번호
	int orderno;
	// 주문번ㅎ호
	int completeno;
	int quantity;
	// ㅈ 주문개수
	String name;
//	// 메뉴 이
	String ordertime;
//	// 주문시간
	String completetime;
	private String accepttime;
	private String paytime;
	private String menu_name;

	public int getCompleteno() {
		return completeno;
	}

	public void setCompleteno(int completeno) {
		this.completeno = completeno;
	}

	public String getAccepttime() {
		return accepttime;
	}

	public void setAccepttime(String accepttime) {
		this.accepttime = accepttime;
	}

	public String getPaytime() {
		return paytime;
	}

	public void setPaytime(String paytime) {
		this.paytime = paytime;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public DtoOrder() {
		// TODO Auto-generated constructor stub
	}

	public DtoOrder(String completetime) {
		super();
		this.completetime = completetime;
	}

	public DtoOrder(String completetime, int completeno) {
		super();
		this.completeno = completeno;
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

	// o.orderno, o.menu_name, o.quantity, o.paytime , c.accepttime , c.completetime
	// rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),
	// rs.getString(5), rs.getString(6)
	public DtoOrder(int orderno, String menu_name, int quantity, String paytime, String accepttime,
			String completetime) {
		this.orderno = orderno;
		this.menu_name = menu_name;
		this.quantity = quantity;
		this.paytime = paytime;
		this.accepttime = accepttime;
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
