package com.example.tipani.tipani.service.impl;

import com.example.tipani.tipani.entity.Department;
import com.example.tipani.tipani.entity.Employee;
import com.example.tipani.tipani.entity.Tipani;
import com.example.tipani.tipani.entity.TipaniStatus;
import com.example.tipani.tipani.entity.dto.EmployeeDTO;
import com.example.tipani.tipani.entity.dto.TipaniDTO;
import com.example.tipani.tipani.repo.DepartmentRepo;
import com.example.tipani.tipani.repo.TipaniRepo;
import com.example.tipani.tipani.service.TipaniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TipaniServiceImpl implements TipaniService {
    @Autowired
    private TipaniRepo repository;
    public TipaniDTO saveEntity(Tipani entity) {
        Tipani savedEmployee = repository.save(entity);
        return new TipaniDTO(savedEmployee);
    }

    public List<TipaniDTO> getAllEntities() {
        return repository.findAll().stream()
                .map(TipaniDTO::new)
                .collect(Collectors.toList());
    }

    public Optional<Tipani> getEntityById(Long id) {
        return repository.findById(id);
    }


    public void deleteEntity(Long id) {
        repository.deleteById(id);
    }

    public Tipani updateStatus(Long id,  Enum status) {
        Optional<Tipani> optionalEntity = repository.findById(id);
        if (optionalEntity.isPresent()) {
            Tipani entity = optionalEntity.get();
            entity.setStatus((TipaniStatus) status);
            return repository.save(entity);
        } else {
            throw new RuntimeException("Entity not found");
        }
    }
}
