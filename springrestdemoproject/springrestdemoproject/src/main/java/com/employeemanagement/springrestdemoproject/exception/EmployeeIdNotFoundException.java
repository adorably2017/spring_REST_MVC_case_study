package com.employeemanagement.springrestdemoproject.exception;

public class EmployeeIdNotFoundException extends RuntimeException {
    public EmployeeIdNotFoundException(String message){
        super(message);

    }
}
