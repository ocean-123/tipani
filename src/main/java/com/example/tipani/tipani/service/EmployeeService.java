package com.example.tipani.tipani.service;

import com.example.tipani.tipani.entity.Department;
import com.example.tipani.tipani.entity.Employee;
import com.example.tipani.tipani.entity.dto.EmployeeDTO;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<EmployeeDTO> getAllEntities();


    EmployeeDTO saveEntity(Employee entity);

    Employee updateStatus(Long id, boolean status);

    void deleteEntity(Long id);

    Optional<Employee> getEntityById(Long id);
}
