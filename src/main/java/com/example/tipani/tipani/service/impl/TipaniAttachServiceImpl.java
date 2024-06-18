package com.example.tipani.tipani.service.impl;

import com.example.tipani.tipani.entity.Department;
import com.example.tipani.tipani.entity.TipaniAttachment;
import com.example.tipani.tipani.entity.TipaniRecomendators;
import com.example.tipani.tipani.entity.dto.TipaniAttachmentDTO;
import com.example.tipani.tipani.entity.dto.TipaniDTO;
import com.example.tipani.tipani.entity.dto.TipaniRecomendatorsDTO;
import com.example.tipani.tipani.repo.DepartmentRepo;
import com.example.tipani.tipani.repo.TipaniAttachmentRepo;
import com.example.tipani.tipani.service.TipaniAttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TipaniAttachServiceImpl implements TipaniAttachService {
    @Autowired
    private TipaniAttachmentRepo repository;
    public TipaniAttachmentDTO saveEntity(TipaniAttachment entity) {
        TipaniAttachment savedEmployee = repository.save(entity);
        return new TipaniAttachmentDTO(savedEmployee);
    }

    public List<TipaniAttachmentDTO> getAllEntities() {
        return repository.findAll().stream()
                .map(TipaniAttachmentDTO::new)
                .collect(Collectors.toList());
    }

    public Optional<TipaniAttachment> getEntityById(Long id) {
        return repository.findById(id);
    }



    public void deleteEntity(Long id) {
        repository.deleteById(id);
    }

    public TipaniAttachment updateStatus(Long id, boolean status) {
        Optional<TipaniAttachment> optionalEntity = repository.findById(id);
        if (optionalEntity.isPresent()) {
            TipaniAttachment entity = optionalEntity.get();
//            entity.setStatus(status);
            return repository.save(entity);
        } else {
            throw new RuntimeException("Entity not found");
        }
    }
}
