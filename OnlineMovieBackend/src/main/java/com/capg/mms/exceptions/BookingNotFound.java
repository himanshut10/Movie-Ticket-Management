package com.capg.mms.exceptions;

@SuppressWarnings("serial")
public class BookingNotFound extends RuntimeException{

	public BookingNotFound(String msg) {
		super(msg);
	}
}
