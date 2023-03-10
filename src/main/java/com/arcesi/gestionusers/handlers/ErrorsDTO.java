package com.arcesi.gestionusers.handlers;

import java.util.List;

import com.arcesi.gestionusers.enumerations.ErrorsCodesEnemuration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Ingénieur de develeppement
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorsDTO {

	private Integer httpCode;
	private ErrorsCodesEnemuration code;
	private String message;
	private List<String> errors;
}
