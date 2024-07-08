package com.example.tipani.tipani.service;

import com.example.tipani.tipani.entity.Employee;
import com.example.tipani.tipani.entity.Tipani;
import com.example.tipani.tipani.entity.dto.EmployeeDTO;
import com.example.tipani.tipani.entity.dto.TipaniDTO;
import com.example.tipani.tipani.service.impl.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<EmployeeDTO> getAllEntities();


    EmployeeDTO saveEntity(Employee entity);

    Employee updateStatus(Long id, boolean status);

    void deleteEntity(Long id);

    Optional<EmployeeDTO> getEntityById(Long id);


    EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) throws ResourceNotFoundException;


    List<TipaniDTO> getTipaniesByEmployeeId(Long employeeId);
}
