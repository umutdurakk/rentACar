package com.example.rentACar;

import com.example.rentACar.core.utilities.exceptions.BusinessException;
import com.example.rentACar.core.utilities.exceptions.ProblemDetails;
import com.example.rentACar.core.utilities.exceptions.ValidationProblemDetails;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@SpringBootApplication
@RestControllerAdvice
public class RentACarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(BusinessException businessException){
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());
		return problemDetails;

	}
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleValidException(MethodArgumentNotValidException methodArgumentNotValidException){
		ValidationProblemDetails problemDetails = new ValidationProblemDetails();
		problemDetails.setMessage("Validation.Exception");
		problemDetails.setValidationsError(new HashMap<String,String>());

		for (FieldError fieldError:methodArgumentNotValidException.getBindingResult().getFieldErrors()
			 ) {
			problemDetails.getValidationsError().put(fieldError.getField(),fieldError.getDefaultMessage());
		}
		return problemDetails;

	}
	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}
}
