package com.wings.wrapper;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class EmployeeRequest {

    @NotEmpty(message = "Name is required")
    private String name;

    @NotEmpty(message = "Email is required")
    @Email(message = "Email format is invalid")
    private String email;

    //@Pattern(regexp="^[a-zA-Z0-9]{3}",message="length must be 3")  
    @NotEmpty(message = "Email is required")
    private String phone;

    @NotEmpty(message = "DepartmentId is required")
    private Long departmentId;
}
