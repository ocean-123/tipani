package com.example.tipani.tipani.controller;


import com.example.tipani.tipani.entity.Department;
import com.example.tipani.tipani.entity.Employee;
import com.example.tipani.tipani.entity.TipaniRecomendators;
import com.example.tipani.tipani.entity.dto.EmployeeDTO;
import com.example.tipani.tipani.entity.dto.TipaniRecomendatorsDTO;
import com.example.tipani.tipani.service.DepartmentService;
import com.example.tipani.tipani.service.TipaniRecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tippani/recommend")
public class TipaniRecomendatorsController {
    @Autowired
    private TipaniRecommendService service;
    @PostMapping
    public ResponseEntity createEntity(@RequestBody TipaniRecomendators entity) {
        return ResponseEntity.ok(service.saveEntity(entity).getId());
    }

    @GetMapping
    public List<TipaniRecomendatorsDTO> getAllEntities() {
        return service.getAllEntities();
    }



    @GetMapping("/{id}")
    public ResponseEntity<TipaniRecomendators> getEntityById(@PathVariable Long id) {
        return service.getEntityById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }



    @PutMapping("/{id}/status")
    public ResponseEntity<TipaniRecomendators> updateStatus(@PathVariable Long id, @RequestBody boolean status) {
        try {
            TipaniRecomendators updatedEntity = service.updateStatus(id, status);
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
