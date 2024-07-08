package com.example.tipani.tipani.service.impl;

import com.example.tipani.tipani.entity.Designation;
import com.example.tipani.tipani.entity.Employee;
import com.example.tipani.tipani.entity.Tipani;
import com.example.tipani.tipani.entity.dto.EmployeeDTO;
import com.example.tipani.tipani.entity.dto.TipaniDTO;
import com.example.tipani.tipani.repo.DesginationRepo;
import com.example.tipani.tipani.repo.EmployeeRepo;
import com.example.tipani.tipani.repo.TipaniRepo;
import com.example.tipani.tipani.service.EmployeeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl  implements EmployeeService {
    @Autowired
    private EmployeeRepo repository;
    //    public List<Employee> getAllEntities() {
//        return repository.findAll();
//    }
    @Autowired
    private TipaniRepo tipaniRepo;

    @Autowired
    private DesginationRepo designationRepository;
    public EmployeeDTO saveEntity(Employee entity) {
        Employee savedEmployee = repository.save(entity);
        return new EmployeeDTO(savedEmployee);
    }

    public List<EmployeeDTO> getAllEntities() {
        return repository.findAll().stream()
                .map(EmployeeDTO::new)
                .collect(Collectors.toList());
    }
    public Optional<EmployeeDTO> getEntityById(Long id) {
        return repository.findById(id)
                .map(EmployeeDTO::new);
    }



//    public Employee saveEntity(Employee entity) {
//        return repository.save(entity);
//    }

    public void deleteEntity(Long id) {
        repository.deleteById(id);
    }

    public Employee updateStatus(Long id, boolean status) {
        Optional<Employee> optionalEntity = repository.findById(id);
        if (optionalEntity.isPresent()) {
            Employee entity = optionalEntity.get();
            entity.setStatus(status);
            return repository.save(entity);
        } else {
            throw new RuntimeException("Entity not found");
        }
    }
    @Transactional
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) throws ResourceNotFoundException {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));

        // Update relevant fields
        employee.setName(employeeDTO.getName());
        employee.setAddress(employeeDTO.getAddress());
        employee.setTel(employeeDTO.getTel());
        employee.setCode(employeeDTO.getCode());
        employee.setCreatedName(employeeDTO.getCreatedName());
        employee.setCreatedDate(employeeDTO.getCreatedDate());
        employee.setUpdateName(employeeDTO.getUpdateName());
        employee.setUpdateDate(employeeDTO.getUpdateDate());

        // Update designation if it exists
        if (employeeDTO.getDesignationId() != null) {
            Designation designation = designationRepository.findById(employeeDTO.getDesignationId())
                    .orElseThrow(() -> new ResourceNotFoundException("Designation not found with id " + employeeDTO.getDesignationId()));
            employee.setDesgination(designation);
        }

        // Save the updated employee
        Employee updatedEmployee = repository.save(employee);

        // Convert updated employee to DTO
        return new EmployeeDTO(updatedEmployee);
    }

    @Override
    public List<TipaniDTO> getTipaniesByEmployeeId(Long employeeId) {
        List<Tipani> tipanis = tipaniRepo.findByEmployeeId(employeeId);
        return tipanis.stream().map(TipaniDTO::new).collect(Collectors.toList());
    }


}
