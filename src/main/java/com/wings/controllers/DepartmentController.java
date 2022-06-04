package com.wings.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wings.entity.Department;
import com.wings.repository.DepartmentRepo;
import com.wings.wrapper.SearchRequest;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    
    @Autowired
    private DepartmentRepo repo;

    @GetMapping
    private Iterable<Department> findAll(){
        return repo.findAll();
    }

    @PostMapping
    public Department createOne(@RequestBody Department department){
        return repo.save(department);
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable("id") Long id){
        return repo.findById(id).orElse(null);
    }

    @GetMapping("/page/{page}/size/{size}")
    private Page<Department> findAllPerPage(@PathVariable("page") int page, @PathVariable("size") int size){
        Pageable pageable = PageRequest.of(page, size);
        return repo.findAll(pageable);
    }

    @GetMapping("/name/{name}")
    private Department findByName(@PathVariable("name") String name){
        return repo.findByName(name);
    }

    @PostMapping("/search")
    public List<Department> findAllByName(@RequestBody SearchRequest search){
        return repo.findByNameContaining(search.getKeyword());
    }
}
