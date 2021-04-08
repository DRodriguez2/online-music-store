package com.HCL.Capstone.onlinemusicstore.exceptions;

public class AccessoryNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public AccessoryNotFoundException() {
		super("NO ACCESSORY PRESENT IN THE DATABASE");
	}
}
