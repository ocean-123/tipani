package com.example.tipani.tipani.service.impl;

import com.example.tipani.tipani.entity.Department;
import com.example.tipani.tipani.entity.Employee;
import com.example.tipani.tipani.entity.TipaniTypes;
import com.example.tipani.tipani.entity.dto.EmployeeDTO;
import com.example.tipani.tipani.entity.dto.TipaniTypesDTO;
import com.example.tipani.tipani.repo.DepartmentRepo;
import com.example.tipani.tipani.repo.TipaniTypesRepo;
import com.example.tipani.tipani.service.TipaniTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TipaniTypesServiceImpl  implements TipaniTypesService {
    @Autowired
    private TipaniTypesRepo repository;


    public TipaniTypesDTO saveEntity(TipaniTypes entity) {
        TipaniTypes savedEmployee = repository.save(entity);
        return new TipaniTypesDTO(savedEmployee);
    }

    public List<TipaniTypesDTO> getAllEntities() {
        return repository.findAll().stream()
                .map(TipaniTypesDTO::new)
                .collect(Collectors.toList());
    }
    public Optional<TipaniTypesDTO> getEntityById(Long id) {
        return repository.findById(id)
                .map(TipaniTypesDTO::new);
    }

    @Override
    public TipaniTypesDTO updateType(Long id, TipaniTypesDTO tipaniTypesDTO) throws ResourceNotFoundException {
        TipaniTypes types = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No type found for"+id));

        types.setId(types.getId());
        types.setTitle(tipaniTypesDTO.getTitle());
        types.setCode(tipaniTypesDTO.getCode());
        types.setCreatedName(tipaniTypesDTO.getCreatedName());
        types.setCreatedDate(tipaniTypesDTO.getCreatedDate());
        types.setUpdateName(tipaniTypesDTO.getUpdateName());
        types.setUpdateDate(tipaniTypesDTO.getUpdateDate());

        TipaniTypes tipaniTypes = repository.save(types);
        return new TipaniTypesDTO(tipaniTypes);
    }


    public void deleteEntity(Long id) {
        repository.deleteById(id);
    }

    public TipaniTypes updateStatus(Long id, boolean status) {
        Optional<TipaniTypes> optionalEntity = repository.findById(id);
        if (optionalEntity.isPresent()) {
            TipaniTypes entity = optionalEntity.get();
            entity.setStatus(status);
            return repository.save(entity);
        } else {
            throw new RuntimeException("Entity not found");
        }
    }
}
