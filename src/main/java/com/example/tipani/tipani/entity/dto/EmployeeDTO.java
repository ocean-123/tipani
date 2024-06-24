package com.example.tipani.tipani.entity.dto;

import com.example.tipani.tipani.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO {
    private Long id;
    private String name;
    private String address;
    private String tel;
    private String code;
    private Long designationId;
    private boolean status;
    private String createdName;
    private Date createdDate;
    private String updateName;
    private Date updateDate;

    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.address = employee.getAddress();
        this.tel = employee.getTel();
        this.code = employee.getCode();
        this.designationId =  (employee.getDesgination() != null) ? employee.getDesgination().getId() : null;
        this.status = employee.isStatus();
        this.createdName = employee.getCreatedName();
        this.createdDate = employee.getCreatedDate();
        this.updateName = employee.getUpdateName();
        this.updateDate = employee.getUpdateDate();
    }
}
