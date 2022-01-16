package com.navar;

public class NaverException extends Exception {
	public NaverException(String msg) {
			super(msg);
			NaverImpl m = new NaverImpl();
		}
	}

