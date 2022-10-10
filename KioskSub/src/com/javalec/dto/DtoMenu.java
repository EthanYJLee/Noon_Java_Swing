package com.javalec.dto;

public class DtoMenu {
	private String name;
	private String category;
	private int price;
	
	public DtoMenu(String name, String category, int price) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
	}
	
	
	public DtoMenu(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
