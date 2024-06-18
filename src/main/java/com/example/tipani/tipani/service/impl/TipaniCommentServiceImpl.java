package com.example.tipani.tipani.service.impl;

import com.example.tipani.tipani.entity.Department;
import com.example.tipani.tipani.entity.Employee;
import com.example.tipani.tipani.entity.TipaniComment;
import com.example.tipani.tipani.entity.TipaniCommentType;
import com.example.tipani.tipani.entity.dto.EmployeeDTO;
import com.example.tipani.tipani.entity.dto.TipaniCommentDTO;
import com.example.tipani.tipani.repo.DepartmentRepo;
import com.example.tipani.tipani.repo.TipaniCommnetRepo;
import com.example.tipani.tipani.service.TipaniCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class  TipaniCommentServiceImpl implements TipaniCommentService {
    @Autowired
    private TipaniCommnetRepo repository;

    public TipaniCommentDTO saveEntity(TipaniComment entity) {
        TipaniComment savedEmployee = repository.save(entity);
        return new TipaniCommentDTO(savedEmployee);
    }

    public List<TipaniCommentDTO> getAllEntities() {
        return repository.findAll().stream()
                .map(TipaniCommentDTO::new)
                .collect(Collectors.toList());
    }

    public Optional<TipaniComment> getEntityById(Long id) {
        return repository.findById(id);
    }



    public void deleteEntity(Long id) {
        repository.deleteById(id);
    }

    public TipaniComment updateStatus(Long id, Enum status) {
        Optional<TipaniComment> optionalEntity = repository.findById(id);
        if (optionalEntity.isPresent()) {
            TipaniComment entity = optionalEntity.get();
            entity.setType((TipaniCommentType) status);
            return repository.save(entity);
        } else {
            throw new RuntimeException("Entity not found");
        }
    }

}
