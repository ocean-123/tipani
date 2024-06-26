package com.example.tipani.tipani.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TipaniApprover {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "TIPANI_ID" ,referencedColumnName = "id")
    private Tipani tipani;

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID",referencedColumnName = "id")
    private Employee employee;

    private String approverName;
    @Column(name = "CREATED_NAME", updatable = false)
    private String createdName;

    @Column(name = "CREATION_DATE", updatable = false)
    private Date createdDate;

    @Column(name = "UPDATE_NAME")
    private String UpdateName;

    @Column(name = "UPDATE_DATE")
    private Date UpdateDate;




}
