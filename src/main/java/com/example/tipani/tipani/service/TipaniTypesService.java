package com.example.tipani.tipani.service;

import com.example.tipani.tipani.entity.Department;
import com.example.tipani.tipani.entity.TipaniTypes;
import com.example.tipani.tipani.entity.dto.TipaniTypesDTO;
import com.example.tipani.tipani.service.impl.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;



public interface TipaniTypesService {
    List<TipaniTypesDTO> getAllEntities();


    TipaniTypesDTO saveEntity(TipaniTypes entity);

    TipaniTypes updateStatus(Long id, boolean status);

    void deleteEntity(Long id);

    Optional<TipaniTypesDTO> getEntityById(Long id);

    TipaniTypesDTO updateType(Long id, TipaniTypesDTO tipaniTypesDTO) throws ResourceNotFoundException;
}
