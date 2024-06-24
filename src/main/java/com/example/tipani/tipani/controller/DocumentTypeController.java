package com.example.tipani.tipani.controller;

import com.example.tipani.tipani.entity.Department;
import com.example.tipani.tipani.entity.DocumentTypes;
import com.example.tipani.tipani.entity.dto.DesignationDTO;
import com.example.tipani.tipani.entity.dto.DocumentTypesDTO;
import com.example.tipani.tipani.entity.dto.EmployeeDTO;
import com.example.tipani.tipani.service.DepartmentService;
import com.example.tipani.tipani.service.DocumentTypeService;
import com.example.tipani.tipani.service.impl.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.DocumentType;

import java.util.List;

@RestController
@RequestMapping("/documentType")
public class DocumentTypeController {
    @Autowired
    private DocumentTypeService service;


    @GetMapping
    public List<DocumentTypes> getAllEntities() {
        return service.getAllEntities();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentTypesDTO> getEntityById(@PathVariable Long id) {
        return service.getEntityById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public DocumentTypes createEntity(@RequestBody DocumentTypes entity) {
        return service.saveEntity(entity);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<DocumentTypes> updateStatus(@PathVariable Long id, @RequestBody boolean status) {
        try {
            DocumentTypes updatedEntity = service.updateStatus(id, status);
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
    public ResponseEntity<DocumentTypesDTO> updateD(@PathVariable Long id, @RequestBody DocumentTypesDTO documentTypesDTO) throws ResourceNotFoundException {
        DocumentTypesDTO dto = service.update(id, documentTypesDTO);
        return ResponseEntity.ok(dto);
    }
}
