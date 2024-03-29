package com.example.emsbackend.service;

import com.example.emsbackend.dto.EmployeeDto;
import com.example.emsbackend.entity.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDto  createEmployee(EmployeeDto employeeDto);
    EmployeeDto  getEmployeeById(Long employeeId);
    List<EmployeeDto> getAllEmployee();
    EmployeeDto updateEmployee(Long employeeId ,EmployeeDto updateEmployee);

    void deleteEmployee(Long employeeId);
}
