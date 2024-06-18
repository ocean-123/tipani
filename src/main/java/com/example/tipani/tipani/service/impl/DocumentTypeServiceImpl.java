package com.example.tipani.tipani.service.impl;

import com.example.tipani.tipani.entity.Department;
import com.example.tipani.tipani.entity.DocumentTypes;
import com.example.tipani.tipani.repo.DepartmentRepo;
import com.example.tipani.tipani.repo.DocumentTypesRepo;
import com.example.tipani.tipani.service.DocumentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentTypeServiceImpl implements DocumentTypeService {
    @Autowired
    private DocumentTypesRepo repository;
    public List<DocumentTypes> getAllEntities() {
        return repository.findAll();
    }

    public Optional<DocumentTypes> getEntityById(Long id) {
        return repository.findById(id);
    }

    public DocumentTypes saveEntity(DocumentTypes entity) {
        return repository.save(entity);
    }

    public void deleteEntity(Long id) {
        repository.deleteById(id);
    }

    public DocumentTypes updateStatus(Long id, boolean status) {
        Optional<DocumentTypes> optionalEntity = repository.findById(id);
        if (optionalEntity.isPresent()) {
            DocumentTypes entity = optionalEntity.get();
            entity.setStatus(status);
            return repository.save(entity);
        } else {
            throw new RuntimeException("Entity not found");
        }
    }
}
