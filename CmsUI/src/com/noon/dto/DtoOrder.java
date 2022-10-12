package com.noon.dto;

public class DtoOrder {
	String paydate;
	String menuname;
	int sum_quantity;
	int count_orderno;
	int count_completetime;
	
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

}
