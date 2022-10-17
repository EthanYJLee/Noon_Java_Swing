package com.noon.dto;

public class DtoOrder2 {

	// 2022.10.17
	
	int shopcode;
	String name;
	private String datepaytime; // date(o.paytime)
	private String menu_name;
	int quantity; // sum(o.quantity)
	private int count; // count(o.orderno)
	int orderno;
	// 주문번호
	
	public DtoOrder2() {
		// TODO Auto-generated constructor stub
	}
	
	public DtoOrder2(int shopcode, String name, String datepaytime, String menu_name, int quantity, int count,
			int orderno) {
		super();
		this.shopcode = shopcode;
		this.name = name;
		this.datepaytime = datepaytime;
		this.menu_name = menu_name;
		this.quantity = quantity;
		this.count = count;
		this.orderno = orderno;
	}
	
	// s.shopcode, s.name, date(o.paytime), o.set_menu_name , sum(o.quantity) , count(o.orderno)
	public int getShopcode() {
		return shopcode;
	}
	public DtoOrder2(int shopcode, String name, String datepaytime, String menu_name, int quantity, int count) {
		super();
		this.shopcode = shopcode;
		this.name = name;
		this.datepaytime = datepaytime;
		this.menu_name = menu_name;
		this.quantity = quantity;
		this.count = count;
	}

	public void setShopcode(int shopcode) {
		this.shopcode = shopcode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDatepaytime() {
		return datepaytime;
	}
	public void setDatepaytime(String datepaytime) {
		this.datepaytime = datepaytime;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getOrderno() {
		return orderno;
	}
	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}
	
}
