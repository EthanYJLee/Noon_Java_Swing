package com.noon.dto;

import java.io.FileInputStream;

public class DtoMenu {

	// Fields
	String name;
	String category;
	int price;
	int filename;
	
	// Constructor
	public DtoMenu() {
		// TODO Auto-generated constructor stub
	}

	public DtoMenu(String name, String category, int price, int filename) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
		this.filename = filename;
	}

	public DtoMenu(String name, int price, int filename) {
		super();
		this.name = name;
		this.price = price;
		this.filename = filename;
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
	
	public int getFilename() {
		return filename;
	}

	public void setFilename(int filename) {
		this.filename = filename;
	}

}
