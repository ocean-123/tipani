package com.example.tipani.tipani.service;

import com.example.tipani.tipani.entity.Department;
import com.example.tipani.tipani.entity.DocumentTypes;
import com.example.tipani.tipani.entity.dto.DocumentTypesDTO;
import com.example.tipani.tipani.service.impl.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface DocumentTypeService {
    List<DocumentTypes> getAllEntities();


    DocumentTypes saveEntity(DocumentTypes entity);

    DocumentTypes updateStatus(Long id, boolean status);

    void deleteEntity(Long id);

    Optional<DocumentTypesDTO> getEntityById(Long id);

    DocumentTypesDTO update(Long id, DocumentTypesDTO documentTypesDTO) throws ResourceNotFoundException;
}
