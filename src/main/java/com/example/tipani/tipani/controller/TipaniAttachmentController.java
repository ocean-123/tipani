package com.example.tipani.tipani.controller;

import com.example.tipani.tipani.entity.Department;
import com.example.tipani.tipani.entity.Employee;
import com.example.tipani.tipani.entity.TipaniAttachment;
import com.example.tipani.tipani.entity.dto.EmployeeDTO;
import com.example.tipani.tipani.entity.dto.TipaniAttachmentDTO;
import com.example.tipani.tipani.service.DepartmentService;
import com.example.tipani.tipani.service.TipaniAttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tippani/attachment")
public class TipaniAttachmentController {
    @Autowired
    private TipaniAttachService service;

    @PostMapping
    public ResponseEntity createEntity(@RequestBody TipaniAttachment entity) {
        return ResponseEntity.ok(service.saveEntity(entity).getId());
    }

    @GetMapping
    public List<TipaniAttachmentDTO> getAllEntities() {
        return service.getAllEntities();
    }


    @GetMapping("/{id}")
    public ResponseEntity<TipaniAttachment> getEntityById(@PathVariable Long id) {
        return service.getEntityById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }



    @PutMapping("/{id}/status")
    public ResponseEntity<TipaniAttachment> updateStatus(@PathVariable Long id, @RequestBody boolean status) {
        try {
            TipaniAttachment updatedEntity = service.updateStatus(id, status);
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
