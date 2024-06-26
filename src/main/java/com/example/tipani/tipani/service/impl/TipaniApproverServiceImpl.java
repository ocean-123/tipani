package com.example.tipani.tipani.service.impl;

import com.example.tipani.tipani.entity.Employee;

import com.example.tipani.tipani.entity.TipaniApprover;

import com.example.tipani.tipani.entity.dto.EmployeeDTO;
import com.example.tipani.tipani.entity.dto.TipaniApproverDTO;
import com.example.tipani.tipani.repo.EmployeeRepo;
import com.example.tipani.tipani.repo.TipaniApproverRepo;
import com.example.tipani.tipani.repo.TipaniRepo;
import com.example.tipani.tipani.service.TipaniApproverService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TipaniApproverServiceImpl implements TipaniApproverService {

    @Autowired
    private TipaniApproverRepo repository;
    @Autowired
    private TipaniRepo tipaniRepository;

    @Autowired
    private EmployeeRepo employeeRepository;


    @Override
    public TipaniApproverDTO saveEntity(TipaniApprover entity) {

        TipaniApprover savedEmployee = repository.save(entity);
        return new TipaniApproverDTO(savedEmployee) ;
    }


    @Override
    public List<TipaniApproverDTO> getAllEntities() {
        return repository.findAll().stream()
                .map(TipaniApproverDTO::new)
                .collect(Collectors.toList());
    }
}
