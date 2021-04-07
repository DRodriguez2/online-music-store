package com.HCL.Capstone.onlinemusicstore.exceptions;

public class NoAlbumsInDatabaseException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoAlbumsInDatabaseException() {
		super("NO ALBUMS PRESENT IN THE DATABASE");
	}
}
