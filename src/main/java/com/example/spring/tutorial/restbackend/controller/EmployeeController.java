package com.example.spring.tutorial.restbackend.controller;

import com.example.spring.tutorial.restbackend.model.Employee;
import com.example.spring.tutorial.restbackend.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    // with responseEntity we can provide additional information (status code)
    // RequestBody creates an Object from a JSON string
    // curl -X POST -H "Content-Type: application/json" -d '{"firstName":"Nazar", "lastName":"Zhuhan", "email":"nazarzhuhan@gmail.com"}' http://localhost:8080/api/employees
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    // build get all employees with REST API
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    // get employee by id
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String id){
        return new ResponseEntity<>(employeeService.getEmployeeById(Integer.parseInt(id)), HttpStatus.OK);
    }

    // update employee by id
    @PutMapping("")
    public ResponseEntity<Employee> updateEmployee()
}
