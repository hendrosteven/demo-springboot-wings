package com.wings.repository;

import org.springframework.data.repository.CrudRepository;

import com.wings.entity.Department;

public interface DepartmentRepo extends CrudRepository<Department, Long> {
    
}
