package com.noon.dto;

public class DtoOrder {

	// Fields
	int orderno;
	String ordertime;
	String refundtime;
	int hotice;
	int quantity;
	int forheretogo;
	int shot;
	int syrup;
	String water;
	int indiprice;
	int customerno;
	
	// Constructor
	public DtoOrder() {
		// TODO Auto-generated constructor stub
	}

	public DtoOrder(int orderno, String ordertime, String refundtime, int hotice, int quantity, int forheretogo,
			int shot, int syrup, String water, int indiprice, int customerno) {
		super();
		this.orderno = orderno;
		this.ordertime = ordertime;
		this.refundtime = refundtime;
		this.hotice = hotice;
		this.quantity = quantity;
		this.forheretogo = forheretogo;
		this.shot = shot;
		this.syrup = syrup;
		this.water = water;
		this.indiprice = indiprice;
		this.customerno = customerno;
	}

	// Method
	public int getOrderno() {
		return orderno;
	}

	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}

	public String getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}

	public String getRefundtime() {
		return refundtime;
	}

	public void setRefundtime(String refundtime) {
		this.refundtime = refundtime;
	}

	public int getHotice() {
		return hotice;
	}

	public void setHotice(int hotice) {
		this.hotice = hotice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getForheretogo() {
		return forheretogo;
	}

	public void setForheretogo(int forheretogo) {
		this.forheretogo = forheretogo;
	}

	public int getShot() {
		return shot;
	}

	public void setShot(int shot) {
		this.shot = shot;
	}

	public int getSyrup() {
		return syrup;
	}

	public void setSyrup(int syrup) {
		this.syrup = syrup;
	}

	public String getWater() {
		return water;
	}

	public void setWater(String water) {
		this.water = water;
	}

	public int getIndiprice() {
		return indiprice;
	}

	public void setIndiprice(int indiprice) {
		this.indiprice = indiprice;
	}

	public int getCustomerno() {
		return customerno;
	}

	public void setCustomerno(int customerno) {
		this.customerno = customerno;
	}
	
	
	
}
