package com.example.tipani.tipani.entity.dto;

import com.example.tipani.tipani.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepartmentDTO {

    private Long id;
    private String title;
    private String code;
    private boolean status;
    private String createdName;
    private Date createdDate;
    private String updateName;
    private Date updateDate;

    private Long tipaniId;
    private Long employeeId;

    public DepartmentDTO(Department department) {
        this.id = department.getId();
        this.title = department.getTitle();
        this.code = department.getCode();
        this.status = department.isStatus();
//        this.employees = designation.getEmployees().stream()
//                .map(EmployeeDTO::new)
//                .collect(Collectors.toList());
        this.createdName = department.getCreatedName();
        this.createdDate = department.getCreatedDate();
        this.updateName = department.getUpdateName();
        this.updateDate = department.getUpdateDate();

        this.tipaniId =(department.getTipani()!=null)? department.getTipani().getId():null;
        this.employeeId = (department.getEmployee()!=null)? department.getEmployee().getId():null;
    }
}
