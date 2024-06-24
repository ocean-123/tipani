package com.example.tipani.tipani.controller;

import com.example.tipani.tipani.entity.Department;
import com.example.tipani.tipani.entity.Designation;
import com.example.tipani.tipani.entity.dto.DesignationDTO;
import com.example.tipani.tipani.entity.dto.EmployeeDTO;
import com.example.tipani.tipani.service.DepartmentService;
import com.example.tipani.tipani.service.DesginationService;
import com.example.tipani.tipani.service.impl.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/designation")
public class DesignationController {
    @Autowired
    private DesginationService service;


//    @GetMapping
//    public ResponseEntity<List<Designation>> getAllEntities() {
//        List<Designation> designations = service.getAllEntities();
//        return ResponseEntity.ok(designations);
//    }
//    @GetMapping
//    public ResponseEntity getAllEntities() {
//        return ResponseEntity.ok(service.getAllEntities());
//    }
@PostMapping
public ResponseEntity createEntity(@RequestBody Designation entity) {
    return  ResponseEntity.ok(service.saveEntity(entity).getId());
}

    @GetMapping
    public List<DesignationDTO> getAllEntities() {
        return service.getAllEntities();
    }


    @GetMapping("/{id}")
    public ResponseEntity<DesignationDTO> getEntityById(@PathVariable Long id) {
        return service.getEntityById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DesignationDTO> updateDesignation(
            @PathVariable Long id,
            @RequestBody DesignationDTO designationDTO) throws ResourceNotFoundException {

        DesignationDTO updatedDesignation = service.updateDesignation(id, designationDTO);

        return ResponseEntity.ok(updatedDesignation);
    }

//    @PostMapping
//    public ResponseEntity<Designation> createDesignation(@RequestBody Designation designation) {
//        Designation savedDesignation = service.saveEntity(designation);
//        return ResponseEntity.ok(savedDesignation);
//    }
//    @PostMapping
//    public ResponseEntity createDesignation(@RequestBody Designation designation) {
//
//        return ResponseEntity.ok(service.saveEntity(designation));
//    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Designation> updateStatus(@PathVariable Long id, @RequestBody boolean status) {
        try {
            Designation updatedEntity = service.updateStatus(id, status);
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
}
