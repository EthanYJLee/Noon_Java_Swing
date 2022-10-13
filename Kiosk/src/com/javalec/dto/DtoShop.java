package com.javalec.dto;

public class DtoShop {
	private int shopcode;
	private String name;
	private String province;
	private String city;
	private String town;
	private String village;
	private String phone;

	public DtoShop() {
		// TODO Auto-generated constructor stub
	}

	public DtoShop(int shopcode, String name, String province, String city, String town, String village, String phone) {
		super();
		this.shopcode = shopcode;
		this.name = name;
		this.province = province;
		this.city = city;
		this.town = town;
		this.village = village;
		this.phone = phone;
	}

	public int getShopcode() {
		return shopcode;
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

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
