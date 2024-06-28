package com.example.tipani.tipani.service;

import com.example.tipani.tipani.entity.Department;
import com.example.tipani.tipani.entity.Tipani;
import com.example.tipani.tipani.entity.TipaniStatus;
import com.example.tipani.tipani.entity.dto.*;
import com.example.tipani.tipani.service.impl.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface TipaniService {
    List<TipaniDTO> getAllEntities();


    TipaniDTO saveEntity(Tipani entity);

    Tipani updateStatus(Long id, Enum status);

    void deleteEntity(Long id);

    Optional<TipaniDTO> getEntityById(Long id);

    TipaniDTO updateTipani(Long id, TipaniDTO tipaniDTO) throws ResourceNotFoundException;

    List<TipaniCommentDTO> getCommentsByTipaniId(Long tipaniId);

    List<TipaniRecomendatorsDTO> getRecomendatorsByTipaniId(Long tipaniId);

    List<TipaniApproverDTO> getapproverByTipaniId(Long tipaniId);

    List<TipaniDTO> getTipanisByStatus(TipaniStatus status);

    List<TipaniAttachmentDTO> getAttachmentByTipaniId(Long tipaniId);
}
