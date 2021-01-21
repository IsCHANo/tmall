package com.ischano.tmall.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class GloabalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public String defaultErrorHandler(Exception e) throws Exception {
    	e.printStackTrace();
    	Class constraintViolationException = Class.forName("org.hibernate.exception.ConstraintViolationException");
    	if(null!=e.getCause()  && constraintViolationException==e.getCause().getClass()) {
    		return "error";
    	}
        return e.getMessage();
    }

}

