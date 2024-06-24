package com.example.tipani.tipani.entity.dto;

import com.example.tipani.tipani.entity.Department;
import com.example.tipani.tipani.entity.DocumentTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentTypesDTO {
    private Long id;
    private String title;
    private String code;
    private boolean status;
    private String createdName;
    private Date createdDate;
    private String updateName;
    private Date updateDate;

    public DocumentTypesDTO(DocumentTypes documentTypes) {
        this.id = documentTypes.getId();
        this.title = documentTypes.getTitle();
        this.code = documentTypes.getCode();
        this.status = documentTypes.isStatus();
//        this.employees = designation.getEmployees().stream()
//                .map(EmployeeDTO::new)
//                .collect(Collectors.toList());
        this.createdName = documentTypes.getCreatedName();
        this.createdDate = documentTypes.getCreatedDate();
        this.updateName = documentTypes.getUpdateName();
        this.updateDate = documentTypes.getUpdateDate();
    }

}
