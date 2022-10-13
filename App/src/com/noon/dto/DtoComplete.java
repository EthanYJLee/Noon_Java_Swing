package com.noon.dto;

public class DtoComplete {

	// Fields
	int completeno;
	String completetime;
	String accepttime;
	
	// Constructor
	public DtoComplete() {
		// TODO Auto-generated constructor stub
	}

	public DtoComplete(int completeno, String completetime, String accepttime) {
		super();
		this.completeno = completeno;
		this.completetime = completetime;
		this.accepttime = accepttime;
	}

	public int getCompleteno() {
		return completeno;
	}

	public void setCompleteno(int completeno) {
		this.completeno = completeno;
	}

	public String getCompletetime() {
		return completetime;
	}

	public void setCompletetime(String completetime) {
		this.completetime = completetime;
	}

	public String getAccepttime() {
		return accepttime;
	}

	public void setAccepttime(String accepttime) {
		this.accepttime = accepttime;
	}
	
	
}
