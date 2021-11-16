package com.testeweb.course.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.testeweb.course.services.exceptions.DatabaseException;
import com.testeweb.course.services.exceptions.EntityNotFoundException;
import com.testeweb.course.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler  {
	//id não encontrado
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest	request)
	{
		String error = "Resource not found!";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	//quebrando regra de integridade -deletando
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest	request)
	{
		String error = "DataBase error!";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	//atualizando
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> update(EntityNotFoundException e, HttpServletRequest	request)
	{
		String error = "DataBase error!";
		HttpStatus status = HttpStatus.UPGRADE_REQUIRED;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
}
