package com.capg.mms.exceptions;

@SuppressWarnings("serial")
public class CityNotFound extends RuntimeException{

	public CityNotFound(String msg) {
		super(msg);
	}
}
