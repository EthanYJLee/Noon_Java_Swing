package com.noon.dto;

public class DtoOrder {

	// Fields
	int orderno;
	String ordertime;
	String refundtime;
	int hotice;
	int quantity;
	String forheretogo;
	int shot;
	int syrup;
	int size;
	int indiprice;
	int customerno;
	String member_id;
	int set_setno;
	String set_menu_name;
	int shop_shopcode;
	String staff_id;
	int filename;

	// Constructor
	public DtoOrder() {
		// TODO Auto-generated constructor stub
	}

	public DtoOrder(int orderno, String ordertime, String refundtime, int hotice, int quantity, String forheretogo,
			int shot, int syrup, int size, int indiprice, int customerno, String member_id, int set_setno,
			String set_menu_name, int shop_shopcode, String staff_id) {
		super();
		this.orderno = orderno;
		this.ordertime = ordertime;
		this.refundtime = refundtime;
		this.hotice = hotice;
		this.quantity = quantity;
		this.forheretogo = forheretogo;
		this.shot = shot;
		this.syrup = syrup;
		this.size = size;
		this.indiprice = indiprice;
		this.customerno = customerno;
		this.member_id = member_id;
		this.set_setno = set_setno;
		this.set_menu_name = set_menu_name;
		this.shop_shopcode = shop_shopcode;
		this.staff_id = staff_id;
	}

	public DtoOrder(String ordertime, int hotice, int quantity, int shot, int syrup, int size, int indiprice,
			String member_id, int set_setno, String set_menu_name, int shop_shopcode, String staff_id) {
		super();
		this.ordertime = ordertime;
		this.hotice = hotice;
		this.quantity = quantity;
		this.shot = shot;
		this.syrup = syrup;
		this.size = size;
		this.indiprice = indiprice;
		this.member_id = member_id;
		this.set_setno = set_setno;
		this.set_menu_name = set_menu_name;
		this.shop_shopcode = shop_shopcode;
		this.staff_id = staff_id;
	}

	public DtoOrder(int orderno, int hotice, int quantity, int shot, int syrup, int size, int indiprice, String set_menu_name,
			int filename) {
		super();
		this.orderno = orderno;
		this.hotice = hotice;
		this.quantity = quantity;
		this.shot = shot;
		this.syrup = syrup;
		this.size = size;
		this.indiprice = indiprice;
		this.set_menu_name = set_menu_name;
		this.filename = filename;
	}

	// -------------
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

	public int getFilename() {
		return filename;
	}

	public void setFilename(int filename) {
		this.filename = filename;
	}

}
