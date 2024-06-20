package com.example.tipani.tipani.service;

import com.example.tipani.tipani.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
     List<Department> getAllEntities();


    Department saveEntity(Department entity);

    Department updateStatus(Long id, boolean status);

    void deleteEntity(Long id);

    Optional<Department> getEntityById(Long id);
}
