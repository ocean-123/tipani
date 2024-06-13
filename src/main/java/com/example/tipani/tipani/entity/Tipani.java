package com.example.tipani.tipani.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Tipani {
//
//
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String   title;
    private String  description;


    @ManyToOne
    @JoinColumn(name= "EMPLOYEE_ID",referencedColumnName = "id")
    private Employee employee;

   @Enumerated
    private TipaniStatus status;

    @OneToMany(mappedBy = "tipani")
    private List<TipaniAttachment> tipaniAttachments;
    @OneToMany(mappedBy = "tipani")
    private List<TipaniRecomendators> tipaniRecomendators;

    @OneToMany(mappedBy = "tipani")
    private List<TipaniComment> tipaniComments;

    @ManyToOne
    @JoinColumn(name= "TIPANI_Types_ID",referencedColumnName = "id")
    private TipaniTypes tipaniTypes;

    @Column(name = "CREATED_NAME", updatable = false)
    private String createdName;

    @Column(name = "CREATION_DATE", updatable = false)
    private Date createdDate;

    @Column(name = "UPDATE_NAME")
    private String UpdateName;

    @Column(name = "UPDATE_DATE")
    private Date UpdateDate;

}
