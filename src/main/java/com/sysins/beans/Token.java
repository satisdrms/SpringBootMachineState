package com.sysins.beans;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Token  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7502027798069480976L;
	
	@NotNull
	private String token;

	protected Token() {
	}
 
	public Token(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return token;
	}

}
