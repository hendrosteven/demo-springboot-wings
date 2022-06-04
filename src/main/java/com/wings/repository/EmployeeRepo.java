package com.wings.repository;

import org.springframework.data.repository.CrudRepository;

import com.wings.entity.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Long> {
    
    public boolean existsByEmailOrPhone(String email, String phone);

}
