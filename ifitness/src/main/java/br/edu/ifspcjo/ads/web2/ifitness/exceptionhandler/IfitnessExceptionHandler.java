package br.edu.ifspcjo.ads.web2.ifitness.exceptionhandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.edu.ifspcjo.ads.web2.ifitness.service.exception.EmailAlreadyRegisteredException;

@ControllerAdvice
public class IfitnessExceptionHandler extends ResponseEntityExceptionHandler{

	@Autowired
	private MessageSource messageSource;

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		String userMessage = messageSource.getMessage("invalid.message", null, LocaleContextHolder.getLocale());
		String developerMessage = ex.getCause() != null ? ex.getCause().toString() : ex.toString();

		return handleExceptionInternal(ex, new ErrorMessage(userMessage, developerMessage), headers, HttpStatus.BAD_REQUEST, request);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		List<ErrorMessage> errors = createErrorList(ex.getBindingResult());
		return handleExceptionInternal(ex, errors, headers, HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler({ EmptyResultDataAccessException.class })
	public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex,
			WebRequest request) {
		String userMessage = messageSource.getMessage("resource.not-found", null, LocaleContextHolder.getLocale());
		String developerMessage = ex.toString();
		List<ErrorMessage> errors = Arrays.asList(new ErrorMessage(userMessage, developerMessage));
		return handleExceptionInternal(ex, errors, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

	@ExceptionHandler({ EmailAlreadyRegisteredException.class })
	public ResponseEntity<Object> handleEmailAlreadyRegisteredException(EmailAlreadyRegisteredException ex,
			WebRequest request) {
		String userMessage = messageSource.getMessage("user.email-already-registered", null,
				LocaleContextHolder.getLocale());
		String developerMessage = ex.toString();
		List<ErrorMessage> errors = Arrays.asList(new ErrorMessage(userMessage, developerMessage));
		return handleExceptionInternal(ex, errors, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	// usuário ou senha incorretos, ou usuário inativo
	@ExceptionHandler({ AuthenticationException.class })
	public ResponseEntity<Object> handleAuthenticationException(AuthenticationException ex, WebRequest request) {
		String userMessage = messageSource.getMessage("security.invalid-credentials", null,
				LocaleContextHolder.getLocale());
		String developerMessage = ex.toString();
		List<ErrorMessage> errors = Arrays.asList(new ErrorMessage(userMessage, developerMessage));
		return handleExceptionInternal(ex, errors, new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
	}

	// usuário autenticado, mas sem a permissão exigida pelo método
	@ExceptionHandler({ AccessDeniedException.class })
	public ResponseEntity<Object> handleAccessDeniedException(AccessDeniedException ex, WebRequest request) {
		String userMessage = messageSource.getMessage("security.access-denied", null,
				LocaleContextHolder.getLocale());
		String developerMessage = ex.toString();
		List<ErrorMessage> errors = Arrays.asList(new ErrorMessage(userMessage, developerMessage));
		return handleExceptionInternal(ex, errors, new HttpHeaders(), HttpStatus.FORBIDDEN, request);
	}

	private List<ErrorMessage> createErrorList(BindingResult bindingResult) {
		List<ErrorMessage> errors = new ArrayList<>();
		for(FieldError fieldError : bindingResult.getFieldErrors()) {
			String userMessage = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
			String developerMessage = fieldError.toString();
			errors.add(new ErrorMessage(userMessage, developerMessage));
		}
		return errors;
	}

	public static class ErrorMessage{
		private String userMessage;
		private String developerMessage;
		public ErrorMessage(String userMessage, String developerMessage) {
			this.userMessage = userMessage;
			this.developerMessage = developerMessage;
		}

		public String getUserMessage() {
			return userMessage;
		}

		public String getDeveloperMessage() {
			return developerMessage;
		}
	}

}
