package com.example.tipani.tipani.service;

import com.example.tipani.tipani.entity.Department;
import com.example.tipani.tipani.entity.Designation;
import com.example.tipani.tipani.entity.dto.DesignationDTO;
import com.example.tipani.tipani.service.impl.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface DesginationService {
    List<DesignationDTO> getAllEntities();


    DesignationDTO saveEntity(Designation entity);

    Designation updateStatus(Long id, boolean status);

    void deleteEntity(Long id);

    Optional<DesignationDTO> getEntityById(Long id);

    DesignationDTO updateDesignation(Long id, DesignationDTO designationDTO) throws ResourceNotFoundException;
}
