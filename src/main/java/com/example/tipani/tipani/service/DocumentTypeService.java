package com.example.tipani.tipani.service;

import com.example.tipani.tipani.entity.Department;
import com.example.tipani.tipani.entity.DocumentTypes;

import java.util.List;
import java.util.Optional;

public interface DocumentTypeService {
    List<DocumentTypes> getAllEntities();


    DocumentTypes saveEntity(DocumentTypes entity);

    DocumentTypes updateStatus(Long id, boolean status);

    void deleteEntity(Long id);

    Optional<DocumentTypes> getEntityById(Long id);
}
