package com.example.emsbackend.controller;

import com.example.emsbackend.dto.EmployeeDto;
import com.example.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
   @Autowired
   private EmployeeService employeeService;
   //Build Add employee REST API
   @PostMapping
   public ResponseEntity<EmployeeDto>  createEmployee(@RequestBody EmployeeDto employeeDto){
      EmployeeDto saveEmployee = employeeService.createEmployee(employeeDto);
      return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
   }

   //Build Get Employee REST API
   @GetMapping("{id}")
   public  ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
      EmployeeDto employeeDto =employeeService.getEmployeeById(employeeId);
      return ResponseEntity.ok(employeeDto);
   }

   // Build Get All Employees REST API
  @GetMapping
   public  ResponseEntity<List<EmployeeDto>> getAllEmployees(){
       List<EmployeeDto>  employees = employeeService.getAllEmployee();
       return ResponseEntity.ok(employees);
   }


   // Build  Update Employee REST API
    @PutMapping("{id}")
   public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId ,
                                                     @RequestBody EmployeeDto updateEmployee){
            EmployeeDto employeeDto= employeeService.updateEmployee(employeeId, updateEmployee);
            return  ResponseEntity.ok(employeeDto);
   }


   //Build Delete Employe REST API
   @DeleteMapping("{id}")
    public  ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
       employeeService.deleteEmployee(employeeId);
       return ResponseEntity.ok("Empolyee deleted successfully !.");
    }
 //test

}
