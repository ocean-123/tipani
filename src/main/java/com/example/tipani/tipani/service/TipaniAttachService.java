package com.example.tipani.tipani.service;

import com.example.tipani.tipani.entity.Department;
import com.example.tipani.tipani.entity.TipaniAttachment;
import com.example.tipani.tipani.entity.dto.EmployeeDTO;
import com.example.tipani.tipani.entity.dto.TipaniAttachmentDTO;
import com.example.tipani.tipani.service.impl.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface TipaniAttachService {
    List<TipaniAttachmentDTO> getAllEntities();


    TipaniAttachmentDTO saveEntity(TipaniAttachment entity);

    TipaniAttachment updateStatus(Long id, boolean status);

    void deleteEntity(Long id);

    Optional<TipaniAttachmentDTO> getEntityById(Long id);

    TipaniAttachmentDTO updateTipaniAttach(Long id, TipaniAttachmentDTO attachmentDTO) throws ResourceNotFoundException;
}
