package com.employeemanagement.springrestdemoproject.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;


public class EmployeeNameNotFoundException extends RuntimeException {
    public EmployeeNameNotFoundException(String message){
        super(message);

    }
}
