package com.employeemanagement.springrestdemoproject.service;

import com.employeemanagement.springrestdemoproject.exception.EmployeeIdNotFoundException;
import com.employeemanagement.springrestdemoproject.exception.EmployeeNameNotFoundException;
import com.employeemanagement.springrestdemoproject.model.Employee;
import com.employeemanagement.springrestdemoproject.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> fetchAllEmployees(){

        return employeeRepository.findAll();
    }

    public Employee getEmployeeByID(int id) {
        Optional<Employee> op=employeeRepository.findById(id);
        if(op.isPresent())
            return op.get();
        else
            throw new EmployeeIdNotFoundException("No employee found with ID:" +id);
    }
    public Employee getEmployeeByName(String employeeName) {
        Optional<Employee> op=employeeRepository.findByEmployeeName(employeeName);
        if(op.isPresent())
            return op.get();
        else
            throw new EmployeeNameNotFoundException("No employee found with name:" +employeeName);
    }


    public Employee insertEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee){
        if(employeeRepository.existsById(employee.getEmployeeId()))
            return employeeRepository.save(employee);
        else
            throw new EmployeeIdNotFoundException("No Employee found with Id:"+employee.getEmployeeId());

    }
    public Employee updateEmployeeByName(Employee employee){
        if(employeeRepository.existsByEmployeeName(employee.getEmployeeName()))
            return employeeRepository.save(employee);
        else
            throw new EmployeeNameNotFoundException("No Employee found with Name:"+employee.getEmployeeName());

    }

    public String deleteEmployee(int id){

        if(employeeRepository.existsById(id))
        {
            employeeRepository.deleteById(id);
            return "Deleted Successfully!!!";
        }
        else
            throw new EmployeeIdNotFoundException("No Employee found with Id:"+id);
    }
    public String deleteEmployeeByName(String employeeName){

        if(employeeRepository.existsByEmployeeName(employeeName))
        {
            employeeRepository.deleteByEmployeeName(employeeName);
            return "Deleted Successfully!!!";
        }
        else
            throw new EmployeeNameNotFoundException("No Employee found with Name:"+employeeName);
    }

}

