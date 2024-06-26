package com.example.tipani.tipani.controller;

import com.example.tipani.tipani.entity.Department;
import com.example.tipani.tipani.entity.dto.DepartmentDTO;
import com.example.tipani.tipani.entity.dto.DesignationDTO;
import com.example.tipani.tipani.entity.dto.EmployeeDTO;
import com.example.tipani.tipani.service.DepartmentService;
import com.example.tipani.tipani.service.impl.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService service;


    @GetMapping
    public List<Department> getAllEntities() {
        return service.getAllEntities();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> getEntityById(@PathVariable Long id) {
        return service.getEntityById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Department createEntity(@RequestBody Department entity) {
        return service.saveEntity(entity);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Department> updateStatus(@PathVariable Long id, @RequestBody boolean status) {
        try {
            Department updatedEntity = service.updateStatus(id, status);
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
    public ResponseEntity<DepartmentDTO> updateEmployee(@PathVariable Long id, @RequestBody DepartmentDTO departmentDTO) throws ResourceNotFoundException {
        DepartmentDTO dto = service.update(id, departmentDTO);
        return ResponseEntity.ok(dto);
    }
}
