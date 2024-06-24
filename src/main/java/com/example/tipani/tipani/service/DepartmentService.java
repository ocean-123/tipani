package com.example.tipani.tipani.service;

import com.example.tipani.tipani.entity.Department;
import com.example.tipani.tipani.entity.dto.DepartmentDTO;
import com.example.tipani.tipani.entity.dto.DesignationDTO;
import com.example.tipani.tipani.service.impl.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
     List<Department> getAllEntities();


    Department saveEntity(Department entity);

    Department updateStatus(Long id, boolean status);

    void deleteEntity(Long id);

    Optional<DepartmentDTO> getEntityById(Long id);

    DepartmentDTO update(Long id, DepartmentDTO departmentDTO) throws ResourceNotFoundException;

//    DepartmentDTO updateDepartment(Long id, DepartmentDTO departmentDTO);
}
