package com.example.tipani.tipani.service.impl;

import com.example.tipani.tipani.entity.*;
import com.example.tipani.tipani.entity.dto.EmployeeDTO;
import com.example.tipani.tipani.entity.dto.TipaniAttachmentDTO;
import com.example.tipani.tipani.entity.dto.TipaniDTO;
import com.example.tipani.tipani.repo.DepartmentRepo;
import com.example.tipani.tipani.repo.EmployeeRepo;
import com.example.tipani.tipani.repo.TipaniRepo;
import com.example.tipani.tipani.repo.TipaniTypesRepo;
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

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private TipaniTypesRepo tipaniTypesRepo;


    public TipaniDTO saveEntity(Tipani entity) {
        Tipani savedEmployee = repository.save(entity);
        return new TipaniDTO(savedEmployee);
    }

    public List<TipaniDTO> getAllEntities() {
        return repository.findAll().stream()
                .map(TipaniDTO::new)
                .collect(Collectors.toList());
    }

    public Optional<TipaniDTO> getEntityById(Long id) {
        return repository.findById(id)
                .map(TipaniDTO::new);
    }

    @Override
    public TipaniDTO updateTipani(Long id, TipaniDTO tipaniDTO) throws ResourceNotFoundException {


        Tipani tipani1 = repository.findById(id)
                    .orElseThrow(()-> new ResourceNotFoundException("Could not find tipani"+id));

        tipani1.setId(tipaniDTO.getId());


        if (tipaniDTO.getEmployeeId() != null) {
            Employee employee = employeeRepo.findById(tipaniDTO.getEmployeeId())
                    .orElseThrow(() -> new ResourceNotFoundException("employee not found with id " + tipaniDTO.getEmployeeId()));
            tipani1.setEmployee(employee);
        }

        if(tipaniDTO.getTipaniTypesId()!= null){
            TipaniTypes tipaniTypes = tipaniTypesRepo.findById(tipaniDTO.getTipaniTypesId())
                   .orElseThrow(() -> new ResourceNotFoundException("TipaniTypes not found with id " + tipaniDTO.getTipaniTypesId()));
            tipani1.setTipaniTypes(tipaniTypes);
        }

        tipani1.setDescription(tipaniDTO.getDescription());
        tipani1.setTitle(tipaniDTO.getTitle());


        tipani1.setCreatedName(tipaniDTO.getCreatedName());
        tipani1.setCreatedDate(tipaniDTO.getCreatedDate());
        tipani1.setUpdateName(tipaniDTO.getUpdateName());
        tipani1.setUpdateDate(tipaniDTO.getUpdateDate());

            Tipani tipani = repository.save(tipani1);

            return new TipaniDTO(tipani);


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
