package com.arcesi.gestionusers.exceptions;

import java.util.List;

import com.arcesi.gestionusers.enumerations.ErrorsCodesEnemuration;

import lombok.Getter;
import lombok.Setter;
/**
 * 
 * @author ingénieur developpement
 *
 */
@Getter
@Setter
//class pour gerer un exception
public class InvalidEntityException extends RuntimeException {

	 
	private static final long serialVersionUID = 1L;
	private ErrorsCodesEnemuration errorsCodesEnemuration;
	private List<String> errors;

	public InvalidEntityException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidEntityException(String message) {
		super(message);
	}

	public InvalidEntityException(String message, Throwable cause, ErrorsCodesEnemuration errorsCodesEnemuration,
			List<String> errors) {
		super(message, cause);
		this.errorsCodesEnemuration = errorsCodesEnemuration;
		this.errors = errors;
	}

	public InvalidEntityException(String message, Throwable cause, ErrorsCodesEnemuration errorsCodesEnemuration) {
		super(message, cause);
		this.errorsCodesEnemuration = errorsCodesEnemuration;

	}

	public InvalidEntityException(String message, ErrorsCodesEnemuration errorsCodesEnemuration, List<String> errors) {
		super(message);
		this.errorsCodesEnemuration = errorsCodesEnemuration;
		this.errors = errors;
	}
}
