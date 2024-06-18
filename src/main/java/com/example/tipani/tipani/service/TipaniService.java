package com.example.tipani.tipani.service;

import com.example.tipani.tipani.entity.Department;
import com.example.tipani.tipani.entity.Tipani;
import com.example.tipani.tipani.entity.dto.TipaniDTO;

import java.util.List;
import java.util.Optional;

public interface TipaniService {
    List<TipaniDTO> getAllEntities();


    TipaniDTO saveEntity(Tipani entity);

    Tipani updateStatus(Long id, Enum status);

    void deleteEntity(Long id);

    Optional<Tipani> getEntityById(Long id);
}
