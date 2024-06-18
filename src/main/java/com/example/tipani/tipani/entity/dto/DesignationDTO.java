package com.example.tipani.tipani.entity.dto;

import com.example.tipani.tipani.entity.Designation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DesignationDTO {
    private Long id;
    private String title;
    private String code;
    private boolean status;
    private List<EmployeeDTO> employees;
    private String createdName;
    private Date createdDate;
    private String updateName;
    private Date updateDate;

    public DesignationDTO(Designation designation) {
        this.id = designation.getId();
        this.title = designation.getTitle();
        this.code = designation.getCode();
        this.status = designation.isStatus();
        this.employees = designation.getEmployees().stream()
                .map(EmployeeDTO::new)
                .collect(Collectors.toList());
        this.createdName = designation.getCreatedName();
        this.createdDate = designation.getCreatedDate();
        this.updateName = designation.getUpdateName();
        this.updateDate = designation.getUpdateDate();
    }
}
