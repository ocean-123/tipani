package com.example.tipani.tipani.controller;


import com.example.tipani.tipani.entity.Department;
import com.example.tipani.tipani.entity.Designation;
import com.example.tipani.tipani.entity.Tipani;
import com.example.tipani.tipani.entity.dto.DesignationDTO;
import com.example.tipani.tipani.entity.dto.DocumentTypesDTO;
import com.example.tipani.tipani.entity.dto.EmployeeDTO;
import com.example.tipani.tipani.entity.dto.TipaniDTO;
import com.example.tipani.tipani.service.DepartmentService;
import com.example.tipani.tipani.service.TipaniService;
import com.example.tipani.tipani.service.impl.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tippani")
public class TipaniController {
    @Autowired
    private TipaniService service;


//    @GetMapping
//    public List<Department> getAllEntities() {
//        return service.getAllEntities();
//    }

    @PostMapping
    public ResponseEntity createEntity(@RequestBody Tipani entity) {
        return  ResponseEntity.ok(service.saveEntity(entity).getId());
    }

    @GetMapping
    public List<TipaniDTO> getAllEntities() {
        return service.getAllEntities();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipaniDTO> getEntityById(@PathVariable Long id) {
        return service.getEntityById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

//    @PostMapping
//    public Department createEntity(@RequestBody Department entity) {
//        return service.saveEntity(entity);
//    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Tipani> updateStatus(@PathVariable Long id, @RequestBody Enum status) {
        try {
            Tipani updatedEntity = service.updateStatus(id, status);
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
    public ResponseEntity<TipaniDTO> updateEmployee(@PathVariable Long id, @RequestBody TipaniDTO tipaniDTO ) throws ResourceNotFoundException {
            TipaniDTO updateTipani = service.updateTipani(id, tipaniDTO);
        return ResponseEntity.ok(updateTipani);
    }
}
