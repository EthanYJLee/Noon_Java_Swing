package com.javalec.dto;

public class DtoOrder {
	private int orderno;
	private int hotice;
	private int quantity;
	private String forheretogo;
	private int shot;
	private int syrup;
	private int size;
	private int indiprice;
	private int customerno;
	private String member_id;
	private int set_setno;
	private String set_menu_name;
	private int shop_shopcode;
	private String staff_id;
	
	public DtoOrder() {
		// TODO Auto-generated constructor stub
	}

	public DtoOrder(int hotice, int quantity, int shot, int syrup, int size) {
		super();
		this.hotice = hotice;
		this.quantity = quantity;
		this.shot = shot;
		this.syrup = syrup;
		this.size = size;
	}

	public int getOrderno() {
		return orderno;
	}

	public void setOrderno(int orderno) {
		this.orderno = orderno;
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

	public String getForheretogo() {
		return forheretogo;
	}

	public void setForheretogo(String forheretogo) {
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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
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

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public int getSet_setno() {
		return set_setno;
	}

	public void setSet_setno(int set_setno) {
		this.set_setno = set_setno;
	}

	public String getSet_menu_name() {
		return set_menu_name;
	}

	public void setSet_menu_name(String set_menu_name) {
		this.set_menu_name = set_menu_name;
	}

	public int getShop_shopcode() {
		return shop_shopcode;
	}

	public void setShop_shopcode(int shop_shopcode) {
		this.shop_shopcode = shop_shopcode;
	}

	public String getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}

	
}