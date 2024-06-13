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
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String   name;
    private String  address;
    private String tel;
    private String  code ;

    @ManyToOne
    @JoinColumn(name= "DEGINATION_ID",referencedColumnName = "id")
      private Designation desgination;

    private boolean status;
    //active ,inactive

    @Column(name = "CREATED_NAME", updatable = false)
    private String createdName;

    @Column(name = "CREATION_DATE", updatable = false)
    private Date createdDate;

    @Column(name = "UPDATE_NAME")
    private String UpdateName;

    @Column(name = "UPDATE_DATE")
    private Date UpdateDate;

}
