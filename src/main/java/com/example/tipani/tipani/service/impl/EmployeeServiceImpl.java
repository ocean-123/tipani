package com.example.tipani.tipani.service.impl;

import com.example.tipani.tipani.entity.Department;
import com.example.tipani.tipani.entity.Employee;
import com.example.tipani.tipani.entity.dto.EmployeeDTO;
import com.example.tipani.tipani.repo.DepartmentRepo;
import com.example.tipani.tipani.repo.EmployeeRepo;
import com.example.tipani.tipani.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl  implements EmployeeService {
    @Autowired
    private EmployeeRepo repository;
//    public List<Employee> getAllEntities() {
//        return repository.findAll();
//    }
public EmployeeDTO saveEntity(Employee entity) {
    Employee savedEmployee = repository.save(entity);
    return new EmployeeDTO(savedEmployee);
}

    public List<EmployeeDTO> getAllEntities() {
        return repository.findAll().stream()
                .map(EmployeeDTO::new)
                .collect(Collectors.toList());
    }
    public Optional<Employee> getEntityById(Long id) {
        return repository.findById(id);
    }

//    public Employee saveEntity(Employee entity) {
//        return repository.save(entity);
//    }

    public void deleteEntity(Long id) {
        repository.deleteById(id);
    }

    public Employee updateStatus(Long id, boolean status) {
        Optional<Employee> optionalEntity = repository.findById(id);
        if (optionalEntity.isPresent()) {
            Employee entity = optionalEntity.get();
            entity.setStatus(status);
            return repository.save(entity);
        } else {
            throw new RuntimeException("Entity not found");
        }
    }
}
