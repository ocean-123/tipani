package com.example.tipani.tipani.service;

import com.example.tipani.tipani.entity.Department;
import com.example.tipani.tipani.entity.TipaniAttachment;
import com.example.tipani.tipani.entity.dto.TipaniAttachmentDTO;

import java.util.List;
import java.util.Optional;

public interface TipaniAttachService {
    List<TipaniAttachmentDTO> getAllEntities();


    TipaniAttachmentDTO saveEntity(TipaniAttachment entity);

    TipaniAttachment updateStatus(Long id, boolean status);

    void deleteEntity(Long id);

    Optional<TipaniAttachment> getEntityById(Long id);
}
