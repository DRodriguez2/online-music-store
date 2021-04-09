package com.HCL.Capstone.onlinemusicstore.exceptions;

public class InstrumentNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public InstrumentNotFoundException() {
		super("NO INSTRUMENT PRESENT IN THE DATABASE");
	}
}
