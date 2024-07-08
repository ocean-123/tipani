package com.example.tipani.tipani.controller;


import com.example.tipani.tipani.entity.Employee;
import com.example.tipani.tipani.entity.Tipani;
import com.example.tipani.tipani.entity.dto.EmployeeDTO;
import com.example.tipani.tipani.entity.dto.TipaniDTO;
import com.example.tipani.tipani.service.EmployeeService;
import com.example.tipani.tipani.service.impl.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService service;


//    @GetMapping
//    public ResponseEntity<List<Employee>> getAllEmployees() {
//        List<Employee> employees = service.getAllEntities();
//        return ResponseEntity.ok(employees);}
//@GetMapping
//public ResponseEntity getAllEmployees() {
//    return ResponseEntity.ok( service.getAllEntities()
//);}


    @PostMapping
    public ResponseEntity createEntity(@RequestBody Employee entity) {
        return ResponseEntity.ok(service.saveEntity(entity).getId());
    }

    @GetMapping
    public List<EmployeeDTO> getAllEntities() {
        return service.getAllEntities();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEntityById(@PathVariable Long id) {
        return service.getEntityById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

//    @PostMapping
//    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
//        Employee savedEmployee = service.saveEntity(employee);
//        return ResponseEntity.ok(savedEmployee);
//    }
//@PostMapping
//public ResponseEntity createEmployee(@RequestBody Employee employee) {
//    return ResponseEntity.ok( service.saveEntity(employee)
//    );
//}
    @PutMapping("/{id}/status")
    public ResponseEntity<Employee> updateStatus(@PathVariable Long id, @RequestBody boolean status) {
        try {
            Employee updatedEntity = service.updateStatus(id, status);
            return ResponseEntity.ok(updatedEntity);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntity(@PathVariable Long id) {
        service.deleteEntity(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) throws ResourceNotFoundException {
        EmployeeDTO updatedEmployee = service.updateEmployee(id, employeeDTO);
        return ResponseEntity.ok(updatedEmployee);
    }

    @GetMapping("/{employeeId}/tipanies")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity getTipaniesByEmployeeId(@PathVariable Long employeeId) {
        List<TipaniDTO> tipanies = service.getTipaniesByEmployeeId(employeeId);
        return ResponseEntity.ok(tipanies);
    }
}
