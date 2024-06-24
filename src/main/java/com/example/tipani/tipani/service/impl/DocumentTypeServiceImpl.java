package com.example.tipani.tipani.service.impl;

import com.example.tipani.tipani.entity.Department;
import com.example.tipani.tipani.entity.DocumentTypes;
import com.example.tipani.tipani.entity.dto.DepartmentDTO;
import com.example.tipani.tipani.entity.dto.DocumentTypesDTO;
import com.example.tipani.tipani.entity.dto.EmployeeDTO;
import com.example.tipani.tipani.repo.DepartmentRepo;
import com.example.tipani.tipani.repo.DocumentTypesRepo;
import com.example.tipani.tipani.service.DocumentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentTypeServiceImpl implements DocumentTypeService {
    @Autowired
    private DocumentTypesRepo repository;
    public List<DocumentTypes> getAllEntities() {
        return repository.findAll();
    }

    public Optional<DocumentTypesDTO> getEntityById(Long id) {
        return repository.findById(id)
                .map(DocumentTypesDTO::new);
    }

    @Override
    public DocumentTypesDTO update(Long id, DocumentTypesDTO documentTypesDTO) throws ResourceNotFoundException {
        DocumentTypes types = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No type found for"+id));

        types.setId(types.getId());
        types.setTitle(documentTypesDTO.getTitle());
        types.setCode(documentTypesDTO.getCode());
        types.setCreatedName(documentTypesDTO.getCreatedName());
        types.setCreatedDate(documentTypesDTO.getCreatedDate());
        types.setUpdateName(documentTypesDTO.getUpdateName());
        types.setUpdateDate(documentTypesDTO.getUpdateDate());

        DocumentTypes documentTypes = repository.save(types);
        return new DocumentTypesDTO(documentTypes);
    }

    public DocumentTypes saveEntity(DocumentTypes entity) {
        return repository.save(entity);
    }

    public void deleteEntity(Long id) {
        repository.deleteById(id);
    }

    public DocumentTypes updateStatus(Long id, boolean status) {
        Optional<DocumentTypes> optionalEntity = repository.findById(id);
        if (optionalEntity.isPresent()) {
            DocumentTypes entity = optionalEntity.get();
            entity.setStatus(status);
            return repository.save(entity);
        } else {
            throw new RuntimeException("Entity not found");
        }
    }
}
