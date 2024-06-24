package com.example.tipani.tipani.service;

import com.example.tipani.tipani.entity.Department;
import com.example.tipani.tipani.entity.TipaniComment;
import com.example.tipani.tipani.entity.dto.TipaniCommentDTO;
import com.example.tipani.tipani.service.impl.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface TipaniCommentService {
    List<TipaniCommentDTO> getAllEntities();


    TipaniCommentDTO saveEntity(TipaniComment entity);

    TipaniComment updateStatus(Long id, Enum status);

    void deleteEntity(Long id);

    Optional<TipaniCommentDTO> getEntityById(Long id);

    TipaniCommentDTO update(Long id, TipaniCommentDTO commentDTO) throws ResourceNotFoundException;
}
