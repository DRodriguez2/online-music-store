package com.HCL.Capstone.onlinemusicstore.exceptions;

public class ServicesNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ServicesNotFoundException() {
		super("NO SERVICE PRESENT IN THE DATABASE");
	}
}
