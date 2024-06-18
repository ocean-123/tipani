package com.example.tipani.tipani.entity.dto;

import com.example.tipani.tipani.entity.TipaniComment;
import com.example.tipani.tipani.entity.TipaniCommentType;
import com.example.tipani.tipani.entity.TipaniStatus;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@NoArgsConstructor
@Data
@AllArgsConstructor

public class TipaniCommentDTO {

    private Long id;
    private Long tipaniId;
    private Long employeeId;
    private TipaniCommentType type;
    private String remarks;
    private Date commentDate;

    private String createdName;
    private Date createdDate;
    private String updateName;
    private Date updateDate;

    public TipaniCommentDTO(TipaniComment comment){
        this.id = comment.getId();
        this.tipaniId = comment.getTipani().getId();
        this.employeeId = comment.getEmployee().getId();
        this.commentDate = comment.getCommentDate();
        this.createdDate = comment.getCreatedDate();
        this.remarks= comment.getRemarks();
        this.type = comment.getType();
        this.createdName = comment.getCreatedName();
        this.updateName = comment.getUpdateName();
        this.updateDate = comment.getUpdateDate();
    }


    }


