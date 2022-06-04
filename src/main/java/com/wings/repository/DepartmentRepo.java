package com.wings.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.wings.entity.Department;

public interface DepartmentRepo extends PagingAndSortingRepository<Department, Long> {
    
    public Department findByName(String name);

    public List<Department> findByNameContaining(String string);
}
