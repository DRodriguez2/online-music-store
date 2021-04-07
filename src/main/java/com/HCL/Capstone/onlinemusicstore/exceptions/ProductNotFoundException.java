package com.HCL.Capstone.onlinemusicstore.exceptions;

public class ProductNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public ProductNotFoundException() {
		super("PRODUCT NOT FOUND BASED ON SEARCH PARAMETERS");
	}
}
