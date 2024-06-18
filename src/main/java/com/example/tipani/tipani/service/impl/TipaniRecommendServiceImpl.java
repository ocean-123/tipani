package com.example.tipani.tipani.service.impl;

import com.example.tipani.tipani.entity.Department;
import com.example.tipani.tipani.entity.Employee;
import com.example.tipani.tipani.entity.TipaniRecomendators;
import com.example.tipani.tipani.entity.dto.EmployeeDTO;
import com.example.tipani.tipani.entity.dto.TipaniRecomendatorsDTO;
import com.example.tipani.tipani.repo.DepartmentRepo;
import com.example.tipani.tipani.repo.TipaniRecomendatorsRepo;
import com.example.tipani.tipani.service.TipaniRecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class TipaniRecommendServiceImpl  implements TipaniRecommendService {
    @Autowired
    private TipaniRecomendatorsRepo repository;

    public TipaniRecomendatorsDTO saveEntity(TipaniRecomendators entity) {
        TipaniRecomendators savedEmployee = repository.save(entity);
        return new TipaniRecomendatorsDTO(savedEmployee);
    }

    public List<TipaniRecomendatorsDTO> getAllEntities() {
        return repository.findAll().stream()
                .map(TipaniRecomendatorsDTO::new)
                .collect(Collectors.toList());
    }


    public Optional<TipaniRecomendators> getEntityById(Long id) {
        return repository.findById(id);
    }



    public void deleteEntity(Long id) {
        repository.deleteById(id);
    }

    public TipaniRecomendators updateStatus(Long id, boolean status) {
        Optional<TipaniRecomendators> optionalEntity = repository.findById(id);
        if (optionalEntity.isPresent()) {
            TipaniRecomendators entity = optionalEntity.get();
//            entity.isHasRecommends(status);
            return repository.save(entity);
        } else {
            throw new RuntimeException("Entity not found");
        }
    }
}
