package com.arcesi.gestionusers.exceptions;

import com.arcesi.gestionusers.enumerations.ErrorsCodesEnemuration;

import lombok.Getter;
import lombok.Setter;

/**
 *  v1
 * @author Ingénieur developpement
 *
 */
@Getter @Setter
public class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private ErrorsCodesEnemuration errorsCodesEnemuration;

	public EntityNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public EntityNotFoundException(String message, Throwable cause, ErrorsCodesEnemuration errorsCodesEnemuration) {
		super(message, cause);
		this.errorsCodesEnemuration = errorsCodesEnemuration;

	}

	public EntityNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stu
	}

	public EntityNotFoundException(String message, ErrorsCodesEnemuration errorsCodes) {
		super(message);
		this.errorsCodesEnemuration = errorsCodes;
	}

}
