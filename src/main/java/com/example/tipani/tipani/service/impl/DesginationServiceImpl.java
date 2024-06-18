package com.example.tipani.tipani.service.impl;

import com.example.tipani.tipani.entity.Department;
import com.example.tipani.tipani.entity.Designation;
import com.example.tipani.tipani.entity.dto.DesignationDTO;
import com.example.tipani.tipani.repo.DepartmentRepo;
import com.example.tipani.tipani.repo.DesginationRepo;
import com.example.tipani.tipani.service.DesginationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DesginationServiceImpl implements DesginationService {
    @Autowired
    private DesginationRepo repository;
//    public List<Designation> getAllEntities() {
//        return repository.findAll();
//    }
public DesignationDTO saveEntity(Designation entity) {
    Designation savedDesignation = repository.save(entity);
    return new DesignationDTO(savedDesignation);
}

    public List<DesignationDTO> getAllEntities() {
        return repository.findAll().stream()
                .map(DesignationDTO::new)
                .collect(Collectors.toList());
    }

    public Optional<Designation> getEntityById(Long id) {
        return repository.findById(id);
    }

//    public Designation saveEntity(Designation entity) {
//        return repository.save(entity);
//    }

    public void deleteEntity(Long id) {
        repository.deleteById(id);
    }

    public Designation updateStatus(Long id, boolean status) {
        Optional<Designation> optionalEntity = repository.findById(id);
        if (optionalEntity.isPresent()) {
            Designation entity = optionalEntity.get();
            entity.setStatus(status);
            return repository.save(entity);
        } else {
            throw new RuntimeException("Entity not found");
        }
    }
}
