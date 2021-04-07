package com.HCL.Capstone.onlinemusicstore.exceptions;

public class NoSongsInDatabaseException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoSongsInDatabaseException() {
		super("NO SONGS PRESENT IN THE DATABASE");
	}
}
