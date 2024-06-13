package com.example.tipani.tipani.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class TipaniAttachment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="TIPANI_ID", referencedColumnName = "id")
    private Tipani tipani;

    @ManyToOne
    @JoinColumn(name="DOC_ID", referencedColumnName = "id")
    private DocumentTypes documentTypes;

    private String fileName;

    private String fileLocation;
     private  String attachmentLocation;

    @Column(name = "CREATED_NAME", updatable = false)
    private String createdName;

    @Column(name = "CREATION_DATE", updatable = false)
    private Date createdDate;

    @Column(name = "UPDATE_NAME")
    private String UpdateName;

    @Column(name = "UPDATE_DATE")
    private Date UpdateDate;

}
