package com.example.tipani.tipani.controller;

import com.example.tipani.tipani.entity.TipaniApprover;
import com.example.tipani.tipani.entity.dto.TipaniApproverDTO;
import com.example.tipani.tipani.entity.dto.TipaniDTO;
import com.example.tipani.tipani.service.TipaniApproverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipani/approver/")

public class TipaniApproverController {

    @Autowired
    private TipaniApproverService service;


    @PostMapping
    public ResponseEntity createEntity(@RequestBody TipaniApprover entity) {
        return ResponseEntity.ok(service.saveEntity(entity).getId());
    }
    @GetMapping
    public List<TipaniApproverDTO> getAllEntities() {
        return service.getAllEntities();
    }

}
