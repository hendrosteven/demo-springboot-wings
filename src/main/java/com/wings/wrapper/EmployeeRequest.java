package com.wings.wrapper;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class EmployeeRequest {

    @NotNull(message = "Name is required")
    private String name;

    @NotNull(message = "Email is required")
    @Email(message = "Email format is invalid")
    private String email;

    //@Pattern(regexp="^[a-zA-Z0-9]{3}",message="length must be 3")  
    @NotNull(message = "Email is required")
    private String phone;

    @NotNull(message = "DepartmentId is required")
    private Long departmentId;
}
