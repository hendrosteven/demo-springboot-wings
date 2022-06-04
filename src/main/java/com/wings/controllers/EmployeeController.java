package com.wings.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wings.entity.Employee;
import com.wings.services.EmployeeService;
import com.wings.wrapper.EmployeeRequest;
import com.wings.wrapper.EmployeeRequest;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    
    @Autowired
    private EmployeeService service;

    @PostMapping
    private ResponseEntity<?> createOne(@Valid @RequestBody EmployeeRequest employeeRequest, Errors errors){

        ResponseData<Employee> response = new ResponseData<>();

        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                response.getMessage().add(error.getDefaultMessage());
            }
            response.setStatus(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        return service.createEmployee(employeeRequest);
    }

    @GetMapping
    public Iterable<Employee> findAll(){
        return service.findAllEmployee();
    }
}
