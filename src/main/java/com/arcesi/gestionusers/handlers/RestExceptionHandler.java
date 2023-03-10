package com.arcesi.gestionusers.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.arcesi.gestionusers.exceptions.EntityNotFoundException;
import com.arcesi.gestionusers.exceptions.InvalidEntityException;

/**
 * 
 * @author Ingénieur de develeppement
 *
 */
//Un lister pour capter les exceptions sur entitynotfountException et InvalidException
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ErrorsDTO> handeException(EntityNotFoundException exception, WebRequest request) {
		final HttpStatus notFound = HttpStatus.NOT_FOUND;
		ErrorsDTO dto = ErrorsDTO.builder()
				.code(exception.getErrorsCodesEnemuration())
				.httpCode(notFound.value())
				.message(exception.getMessage()).build();
		
		return new ResponseEntity<ErrorsDTO>(dto,notFound);
	}
	
	@ExceptionHandler(InvalidEntityException.class)
	public ResponseEntity<ErrorsDTO> handeException(InvalidEntityException exception,WebRequest request){
		final HttpStatus badRequest=HttpStatus.BAD_REQUEST;
		ErrorsDTO dto=ErrorsDTO.builder()
				.code(exception.getErrorsCodesEnemuration())
				.httpCode(badRequest.value())
				.message(exception.getMessage())
				.errors(exception.getErrors())
				
				.build();
		return new ResponseEntity<ErrorsDTO>(dto,badRequest);
	}

}
