package com.example.tipani.tipani.service;

import com.example.tipani.tipani.entity.Department;
import com.example.tipani.tipani.entity.TipaniRecomendators;
import com.example.tipani.tipani.entity.dto.TipaniRecomendatorsDTO;

import java.util.List;
import java.util.Optional;

public interface TipaniRecommendService {
    List<TipaniRecomendatorsDTO> getAllEntities();


    TipaniRecomendatorsDTO saveEntity(TipaniRecomendators entity);

    TipaniRecomendators updateStatus(Long id, boolean status);

    void deleteEntity(Long id);

    Optional<TipaniRecomendators> getEntityById(Long id);
}
