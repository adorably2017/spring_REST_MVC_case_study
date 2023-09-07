package com.employeemanagement.springrestdemoproject.controller;

import com.employeemanagement.springrestdemoproject.model.Employee;
import com.employeemanagement.springrestdemoproject.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){

        return employeeService.fetchAllEmployees();
    }
    @GetMapping("/employees/{id}")
    public Employee getEmployeeByID(@PathVariable("id") int id) {

        return employeeService.getEmployeeByID(id);
    }

    @GetMapping("/employees/byName/{name}")
    public ResponseEntity<Employee> getEmployeeByName(@PathVariable("name") String name)
    {
        Employee e = employeeService.getEmployeeByName(name);
        ResponseEntity<Employee> re= new ResponseEntity<Employee>(e, HttpStatus.OK);
        return re;
    }

    @PostMapping("/employees")
    public Employee insertEmployee(@Valid @RequestBody Employee employee){

        return employeeService.insertEmployee(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@Valid @RequestBody Employee employee){

        return employeeService.updateEmployee(employee);
    }
    @PutMapping("/employees/byName/{name}")
    public Employee updateEmployeeByName(@RequestBody Employee employee){

        return employeeService.updateEmployeeByName(employee);
    }
    @DeleteMapping("/employees/{id}")
    public  String deleteEmployee(@PathVariable("id") int id){
        System.out.println("delete of RestAPI");
        return employeeService.deleteEmployee(id);
    }
    @DeleteMapping("/employees/byName/{name}")
    public String deleteTraineeByName(@PathVariable("name") String name)
    {
        return employeeService.deleteEmployeeByName(name);
    }


}
