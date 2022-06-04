package com.wings.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wings.entity.Employee;
import com.wings.repository.DepartmentRepo;
import com.wings.repository.EmployeeRepo;
import com.wings.wrapper.EmployeeRequest;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepo repo;

    @Autowired
    private DepartmentRepo departmentRepo;
    
    public Employee createEmployee(EmployeeRequest employeeRequest){
        if(repo.existsByEmailOrPhone(employeeRequest.getEmail(), employeeRequest.getPhone())){
            throw new RuntimeException("Email or Phone already exist");
        }
        Employee employee = new Employee();
        employee.setName(employeeRequest.getName());
        employee.setEmail(employeeRequest.getEmail());
        employee.setPhone(employeeRequest.getPhone());
        employee.setDepartment(departmentRepo.findById(employeeRequest.getDepartmentId()).orElse(null));
        return repo.save(employee);
    }

    public Iterable<Employee> findAllEmployee(){
        return repo.findAll();
    }
}
