package com.example.tipani.tipani.service.impl;

import com.example.tipani.tipani.entity.*;
import com.example.tipani.tipani.entity.dto.EmployeeDTO;
import com.example.tipani.tipani.entity.dto.TipaniCommentDTO;
import com.example.tipani.tipani.repo.DepartmentRepo;
import com.example.tipani.tipani.repo.EmployeeRepo;
import com.example.tipani.tipani.repo.TipaniCommnetRepo;
import com.example.tipani.tipani.repo.TipaniRepo;
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

    @Autowired
    private TipaniRepo tipaniRepo;

    @Autowired
    private EmployeeRepo employeeRepo;
    public TipaniCommentDTO saveEntity(TipaniComment entity) {
        TipaniComment savedEmployee = repository.save(entity);
        return new TipaniCommentDTO(savedEmployee);
    }

    public List<TipaniCommentDTO> getAllEntities() {
        return repository.findAll().stream()
                .map(TipaniCommentDTO::new)
                .collect(Collectors.toList());
    }

    public Optional<TipaniCommentDTO> getEntityById(Long id) {
        return repository.findById(id)
                .map(TipaniCommentDTO::new);
    }

    @Override
    public TipaniCommentDTO update(Long id, TipaniCommentDTO commentDTO) throws ResourceNotFoundException {

        TipaniComment tipaniComment = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Could not find tipaniRecom"+id));


        tipaniComment.setId(commentDTO.getId());
        tipaniComment.setRemarks(commentDTO.getRemarks());
        tipaniComment.setCreatedName(commentDTO.getCreatedName());
        tipaniComment.setCreatedDate(commentDTO.getCreatedDate());
        tipaniComment.setUpdateName(commentDTO.getUpdateName());
        tipaniComment.setUpdateDate(commentDTO.getUpdateDate());
        tipaniComment.setCommentDate(commentDTO.getCommentDate());

        if (commentDTO.getTipaniId() != null) {
            Tipani tipani = tipaniRepo.findById(commentDTO.getTipaniId())
                    .orElseThrow(() -> new ResourceNotFoundException("Tipani not found with id " + commentDTO.getTipaniId()));
            tipaniComment.setTipani(tipani);
        }
        if (commentDTO.getEmployeeId() != null) {
            Employee employee = employeeRepo.findById(commentDTO.getEmployeeId())
                    .orElseThrow(() -> new ResourceNotFoundException("employee not found with id " + commentDTO.getEmployeeId()));
            tipaniComment.setEmployee(employee);
        }

        TipaniComment comment = repository.save(tipaniComment);
        return new TipaniCommentDTO(comment);
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
