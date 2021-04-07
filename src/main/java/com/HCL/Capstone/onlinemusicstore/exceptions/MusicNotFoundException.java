package com.HCL.Capstone.onlinemusicstore.exceptions;

public class MusicNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public MusicNotFoundException() {
		super("MUSIC NOT FOUND BASED ON SEARCH PARAMETERS");
	}
}
