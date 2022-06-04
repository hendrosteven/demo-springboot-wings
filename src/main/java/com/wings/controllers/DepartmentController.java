package com.wings.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wings.entity.Department;
import com.wings.repository.DepartmentRepo;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    
    @Autowired
    private DepartmentRepo repo;

    @GetMapping
    private Iterable<Department> findAll(){
        return repo.findAll();
    }
}
