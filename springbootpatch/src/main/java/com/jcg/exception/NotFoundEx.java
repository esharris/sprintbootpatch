package com.jcg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundEx extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3178798201664229573L;

	public NotFoundEx(String message) {
		super(message);
	}
}
