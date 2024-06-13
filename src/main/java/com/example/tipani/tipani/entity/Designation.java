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
public class Designation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String title;
    private String code;



    @OneToMany(mappedBy = "desgination")
    private List<Employee> employees;

    @Column(name = "CREATED_NAME", updatable = false)
    private String createdName;

    @Column(name = "CREATION_DATE", updatable = false)
    private Date createdDate;

    @Column(name = "UPDATE_NAME")
    private String UpdateName;

    @Column(name = "UPDATE_DATE")
    private Date UpdateDate;
}
