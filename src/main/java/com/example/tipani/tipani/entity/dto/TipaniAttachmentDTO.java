package com.example.tipani.tipani.entity.dto;


import com.example.tipani.tipani.entity.DocumentTypes;
import com.example.tipani.tipani.entity.Tipani;
import com.example.tipani.tipani.entity.TipaniAttachment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipaniAttachmentDTO {


    private Long id;


    private Long tipaniId;


    private Long documentTypesId;

    private String fileName;

    private String fileLocation;
    private  String attachmentLocation;

    private String createdName;

    private Date createdDate;

    private String updateName;

    private Date updateDate;

    public TipaniAttachmentDTO(TipaniAttachment attachment){

        this.id = attachment.getId();
        this.tipaniId = attachment.getTipani().getId();
        this.documentTypesId = attachment.getDocumentTypes().getId();
        this.fileName = attachment.getFileName();
        this.fileLocation = attachment.getFileLocation();
        this.attachmentLocation = attachment.getAttachmentLocation();
        this.createdName = attachment.getCreatedName();
        this.createdDate = attachment.getCreatedDate();
        this.updateName = attachment.getUpdateName();
        this.updateDate = attachment.getUpdateDate();

    }

}
