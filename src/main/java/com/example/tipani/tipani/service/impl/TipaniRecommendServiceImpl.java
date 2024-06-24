package com.example.tipani.tipani.service.impl;

import com.example.tipani.tipani.entity.*;
import com.example.tipani.tipani.entity.dto.EmployeeDTO;
import com.example.tipani.tipani.entity.dto.TipaniRecomendatorsDTO;
import com.example.tipani.tipani.repo.DepartmentRepo;
import com.example.tipani.tipani.repo.EmployeeRepo;
import com.example.tipani.tipani.repo.TipaniRecomendatorsRepo;
import com.example.tipani.tipani.repo.TipaniRepo;
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

    @Autowired
    private TipaniRepo tipaniRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    public TipaniRecomendatorsDTO saveEntity(TipaniRecomendators entity) {
        TipaniRecomendators savedEmployee = repository.save(entity);
        return new TipaniRecomendatorsDTO(savedEmployee);
    }

    public List<TipaniRecomendatorsDTO> getAllEntities() {
        return repository.findAll().stream()
                .map(TipaniRecomendatorsDTO::new)
                .collect(Collectors.toList());
    }


    public Optional<TipaniRecomendatorsDTO> getEntityById(Long id) {
        return repository.findById(id)
                .map(TipaniRecomendatorsDTO::new);
    }

    @Override
    public TipaniRecomendatorsDTO updateTipRecom(Long id, TipaniRecomendatorsDTO tipaniRecomendatorsDTO) throws ResourceNotFoundException {
        TipaniRecomendators recomendators = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Could not find tipaniRecom"+id));

        recomendators.setId(tipaniRecomendatorsDTO.getId());
        recomendators.setPosition(tipaniRecomendatorsDTO.getPosition());
        if (tipaniRecomendatorsDTO.getTipaniId() != null) {
            Tipani tipani = tipaniRepo.findById(tipaniRecomendatorsDTO.getTipaniId())
                    .orElseThrow(() -> new ResourceNotFoundException("Tipani not found with id " + tipaniRecomendatorsDTO.getTipaniId()));
            recomendators.setTipani(tipani);
        }
        if (tipaniRecomendatorsDTO.getEmployeeId() != null) {
            Employee employee = employeeRepo.findById(tipaniRecomendatorsDTO.getEmployeeId())
                    .orElseThrow(() -> new ResourceNotFoundException("employee not found with id " + tipaniRecomendatorsDTO.getEmployeeId()));
            recomendators.setEmployee(employee);
        }


        TipaniRecomendators updated = repository.save(recomendators);

        // Convert updated employee to DTO
        return new TipaniRecomendatorsDTO(updated);
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
