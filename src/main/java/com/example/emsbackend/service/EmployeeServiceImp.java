package com.example.emsbackend.service;

import com.example.emsbackend.dto.EmployeeDto;
import com.example.emsbackend.entity.Employee;
import com.example.emsbackend.exception.ResourceNotFoundExeption;
import com.example.emsbackend.mappers.EmployeeMapper;
import com.example.emsbackend.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EmployeeServiceImp implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee    employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);

    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee=employeeRepository.findById(employeeId).orElseThrow(()->
        new ResourceNotFoundExeption("Employee is not exists whid givn id"+employeeId));
        return  EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        //return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
               // .collect(Collectors.toList());
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee) {
        Employee employee=employeeRepository.findById(employeeId).orElseThrow(()->
                new ResourceNotFoundExeption("Employee is not exists whid givn id"+employeeId));

        employee.setFirstName(updateEmployee.getFirstName());
        employee.setLastName(updateEmployee.getLastName());
        employee.setEmail(updateEmployee.getEmail());
        Employee updateEmployeeObj = employeeRepository.save(employee);


        return  EmployeeMapper.mapToEmployeeDto(updateEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee=employeeRepository.findById(employeeId).orElseThrow(()->
                new ResourceNotFoundExeption("Employee is not exists whid givn id"+employeeId));

        employeeRepository.delete(employee);


    }
}

