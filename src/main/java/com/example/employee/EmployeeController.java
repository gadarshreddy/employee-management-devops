package com.example.employee;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/employees")
// Employee Management REST API
public class EmployeeController {

    private final List<Map<String, Object>> employees = new ArrayList<>();

    public EmployeeController() {
        employees.add(Map.of("id", 1, "name", "Adarsh", "role", "Developer"));
        employees.add(Map.of("id", 2, "name", "Rahul", "role", "Tester"));
        employees.add(Map.of("id", 3, "name", "Priya", "role", "Manager"));
    }

    @GetMapping
    public List<Map<String, Object>> getAllEmployees() {
        return employees;
    }

    @GetMapping("/{id}")
    public Map<String, Object> getEmployee(@PathVariable int id) {
        return employees.stream()
                .filter(e -> e.get("id").equals(id))
                .findFirst()
                .orElse(Map.of("message", "Employee not found"));
    }

    @PostMapping
    public Map<String, Object> addEmployee(@RequestBody Map<String, Object> employee) {
        employees.add(employee);
        return employee;
    }
}
