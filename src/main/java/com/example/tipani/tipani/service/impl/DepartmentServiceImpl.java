package com.example.tipani.tipani.service.impl;

import com.example.tipani.tipani.entity.Department;
import com.example.tipani.tipani.repo.DepartmentRepo;
import com.example.tipani.tipani.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl  implements DepartmentService {

    @Autowired
    private DepartmentRepo repository;
    public List<Department> getAllEntities() {
        return repository.findAll();
    }

    public Optional<Department> getEntityById(Long id) {
        return repository.findById(id);
    }

    public Department saveEntity(Department entity) {
        return repository.save(entity);
    }

    public void deleteEntity(Long id) {
        repository.deleteById(id);
    }

    public Department updateStatus(Long id, boolean status) {
        Optional<Department> optionalEntity = repository.findById(id);
        if (optionalEntity.isPresent()) {
            Department entity = optionalEntity.get();
            entity.setStatus(status);
            return repository.save(entity);
        } else {
            throw new RuntimeException("Entity not found");
        }
    }
}
