package com.example.tipani.tipani.entity.dto;

import com.example.tipani.tipani.entity.Designation;
import com.example.tipani.tipani.entity.TipaniTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TipaniTypesDTO {
    private Long id;
    private String title;
    private String code;
    private boolean status;
    private String createdName;
    private Date createdDate;
    private String updateName;
    private Date updateDate;

    public  TipaniTypesDTO(TipaniTypes tipaniTypes) {
        this.id = tipaniTypes.getId();
        this.title = tipaniTypes.getTitle();
        this.code = tipaniTypes.getCode();
        this.status = tipaniTypes.isStatus();
//        this.employees = designation.getEmployees().stream()
//                .map(EmployeeDTO::new)
//                .collect(Collectors.toList());
        this.createdName = tipaniTypes.getCreatedName();
        this.createdDate = tipaniTypes.getCreatedDate();
        this.updateName = tipaniTypes.getUpdateName();
        this.updateDate = tipaniTypes.getUpdateDate();
    }
}
