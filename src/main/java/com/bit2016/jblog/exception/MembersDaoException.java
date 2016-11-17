package com.bit2016.jblog.exception;

public class MembersDaoException extends RuntimeException {
	private static final long serialVersionUID = 75687482485855900L;

	public MembersDaoException() {
		super("User Not Found");
	}

}
