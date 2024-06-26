package com.example.tipani.tipani.service;

import com.example.tipani.tipani.entity.DocumentTypes;
import com.example.tipani.tipani.entity.Employee;
import com.example.tipani.tipani.entity.TipaniApprover;
import com.example.tipani.tipani.entity.dto.EmployeeDTO;
import com.example.tipani.tipani.entity.dto.TipaniApproverDTO;
import com.example.tipani.tipani.service.impl.ResourceNotFoundException;
import jakarta.persistence.metamodel.IdentifiableType;

import java.util.List;

public interface TipaniApproverService {


    TipaniApproverDTO saveEntity(TipaniApprover entity);

    List<TipaniApproverDTO> getAllEntities();
}
