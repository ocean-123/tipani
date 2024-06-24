package com.example.tipani.tipani.controller;

import com.example.tipani.tipani.entity.Employee;
import com.example.tipani.tipani.entity.TipaniTypes;
import com.example.tipani.tipani.entity.dto.DocumentTypesDTO;
import com.example.tipani.tipani.entity.dto.EmployeeDTO;
import com.example.tipani.tipani.entity.dto.TipaniTypesDTO;
import com.example.tipani.tipani.service.EmployeeService;
import com.example.tipani.tipani.service.TipaniTypesService;
import com.example.tipani.tipani.service.impl.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipaniTypes")

public class TipaniTypesController {
    @Autowired
    private TipaniTypesService service;





    @PostMapping
    public ResponseEntity createEntity(@RequestBody TipaniTypes entity) {
        return ResponseEntity.ok(service.saveEntity(entity).getId());
    }

    @GetMapping
    public List<TipaniTypesDTO> getAllEntities() {
        return service.getAllEntities();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipaniTypesDTO> getEntityById(@PathVariable Long id) {
        return service.getEntityById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}/status")
    public ResponseEntity<TipaniTypes> updateStatus(@PathVariable Long id, @RequestBody boolean status) {
        try {
            TipaniTypes updatedEntity = service.updateStatus(id, status);
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
    public ResponseEntity<TipaniTypesDTO> updateTipaniTypes(
            @PathVariable Long id,
            @RequestBody TipaniTypesDTO tipaniTypesDTO
    ) throws ResourceNotFoundException {
        TipaniTypesDTO tipaniTypesDTO1 = service.updateType(id, tipaniTypesDTO);
        return ResponseEntity.ok(tipaniTypesDTO1);

    }



}
