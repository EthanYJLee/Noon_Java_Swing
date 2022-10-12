package com.noon.dto;

public class DtoSetting {
	private String menu_name;
	private String categorynow;
	private int pricenow;
	
	public DtoSetting(String menu_name, String categorynow, int pricenow) {
		super();
		this.menu_name = menu_name;
		this.categorynow = categorynow;
		this.pricenow = pricenow;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public String getCategorynow() {
		return categorynow;
	}

	public void setCategorynow(String categorynow) {
		this.categorynow = categorynow;
	}

	public int getPricenow() {
		return pricenow;
	}

	public void setPricenow(int pricenow) {
		this.pricenow = pricenow;
	}
	
	
	
}
