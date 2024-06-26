package com.example.tipani.tipani.entity.dto;


import com.example.tipani.tipani.entity.TipaniApprover;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TipaniApproverDTO {

    private Long id;
    private Long tipaniId;
    private String approverName;
    private Long employeeId;

    private String createdName;
    private Date createdDate;
    private String updateName;
    private Date updateDate;

    public TipaniApproverDTO(TipaniApprover approver){
        this.id = approver.getId();
        this.tipaniId = approver.getTipani() != null ? approver.getTipani().getId() : null;
        this.approverName = approver.getApproverName();
        this.employeeId = approver.getEmployee() != null ? approver.getEmployee().getId() : null;
        this.createdName = approver.getCreatedName();
        this.createdDate = approver.getCreatedDate();
        this.updateName = approver.getUpdateName();
        this.updateDate = approver.getUpdateDate();


    }

}
