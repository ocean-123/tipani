package com.example.tipani.tipani.entity.dto;

import com.example.tipani.tipani.entity.Tipani;
import com.example.tipani.tipani.entity.TipaniStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TipaniDTO {
    private Long id;
    private String title;
    private String description;
    private Long employeeId;
    private TipaniStatus status;
    private Long tipaniTypesId;
    private String createdName;
    private Date createdDate;
    private String UpdateName;
    private Date UpdateDate;

    public TipaniDTO(Tipani tipani){
        this.id= tipani.getId();
        this.title= tipani.getTitle();
        this.description= tipani.getDescription();
        this.employeeId= tipani.getEmployee().getId();
        this.status= tipani.getStatus();
        this.tipaniTypesId= tipani.getTipaniTypes().getId();
        this.createdName= tipani.getCreatedName();
        this.createdDate= tipani.getCreatedDate();
        this.UpdateName= tipani.getUpdateName();
        this.UpdateDate= tipani.getUpdateDate();


    }
}
