package com.arcesi.gestionusers.enumerations;

public enum ErrorsCodesEnemuration {
	
	USER_NOT_FOUND(1000),
	USER_NOT_VALID(1001),
	
	ROLE_NOT_FOUND(2000);
	
	public final int   code;

	private ErrorsCodesEnemuration(int code) {
		this.code=code;
	}
	public int getCode() {
		return code;
	}
	

}
