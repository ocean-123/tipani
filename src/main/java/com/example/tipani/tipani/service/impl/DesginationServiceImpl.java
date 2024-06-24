package com.example.tipani.tipani.service.impl;

import com.example.tipani.tipani.entity.Department;
import com.example.tipani.tipani.entity.Designation;
import com.example.tipani.tipani.entity.Employee;
import com.example.tipani.tipani.entity.dto.DesignationDTO;
import com.example.tipani.tipani.entity.dto.EmployeeDTO;
import com.example.tipani.tipani.repo.DepartmentRepo;
import com.example.tipani.tipani.repo.DesginationRepo;
import com.example.tipani.tipani.service.DesginationService;
import com.example.tipani.tipani.service.EmployeeService;
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
@Autowired
private EmployeeService employeeService;
public DesignationDTO saveEntity(Designation entity) {
    Designation savedDesignation = repository.save(entity);
    return new DesignationDTO(savedDesignation);
}

@Override
    public DesignationDTO updateDesignation(Long id, DesignationDTO designationDTO) throws ResourceNotFoundException {
        Designation designation = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Designation not found with id " + id));

        designation.setTitle(designationDTO.getTitle());
        designation.setCode(designationDTO.getCode());

        designation.setCreatedName(designationDTO.getCreatedName());
        designation.setCreatedDate(designationDTO.getCreatedDate());
        designation.setUpdateName(designationDTO.getUpdateName());
        designation.setUpdateDate(designationDTO.getUpdateDate());

        // Map employees
//        List<Employee> employees = designationDTO.getEmployees().stream()
//                .map(employeeDTO -> {
//                    try {
//                        return employeeService.getEntityById(employeeDTO.getId())
//                                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + employeeDTO.getId()));
//                    } catch (ResourceNotFoundException e) {
//                        throw new RuntimeException(e);
//                    }
//                })
//                .collect(Collectors.toList());
//        designation.setEmployees(employees);

        // Save the updated designation
        Designation updatedDesignation = repository.save(designation);

        // Convert updated designation to DTO
        return new DesignationDTO(updatedDesignation);
    }

    public List<DesignationDTO> getAllEntities() {
        return repository.findAll().stream()
                .map(DesignationDTO::new)
                .collect(Collectors.toList());
    }

    public Optional<DesignationDTO> getEntityById(Long id) {
        return repository.findById(id)
                .map(DesignationDTO::new);
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
