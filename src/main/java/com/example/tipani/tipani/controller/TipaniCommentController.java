package com.example.tipani.tipani.controller;


import com.example.tipani.tipani.entity.Department;
import com.example.tipani.tipani.entity.Employee;
import com.example.tipani.tipani.entity.TipaniComment;
import com.example.tipani.tipani.entity.dto.EmployeeDTO;
import com.example.tipani.tipani.entity.dto.TipaniCommentDTO;
import com.example.tipani.tipani.service.DepartmentService;
import com.example.tipani.tipani.service.TipaniCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tippani/comment")
public class TipaniCommentController {
    @Autowired
    private TipaniCommentService service;


    @PostMapping
    public ResponseEntity createEntity(@RequestBody TipaniComment entity) {
        return ResponseEntity.ok(service.saveEntity(entity).getId());
    }

    @GetMapping
    public List<TipaniCommentDTO> getAllEntities() {
        return service.getAllEntities();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipaniComment> getEntityById(@PathVariable Long id) {
        return service.getEntityById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}/status")
    public ResponseEntity<TipaniComment> updateStatus(@PathVariable Long id, @RequestBody Enum status) {
        try {
            TipaniComment updatedEntity = service.updateStatus(id, status);
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
