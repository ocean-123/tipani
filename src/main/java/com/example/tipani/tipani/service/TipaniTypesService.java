package com.example.tipani.tipani.service;

import com.example.tipani.tipani.entity.Department;
import com.example.tipani.tipani.entity.TipaniTypes;
import com.example.tipani.tipani.entity.dto.TipaniTypesDTO;

import java.util.List;
import java.util.Optional;



public interface TipaniTypesService {
    List<TipaniTypesDTO> getAllEntities();


    TipaniTypesDTO saveEntity(TipaniTypes entity);

    TipaniTypes updateStatus(Long id, boolean status);

    void deleteEntity(Long id);

    Optional<TipaniTypes> getEntityById(Long id);
}
