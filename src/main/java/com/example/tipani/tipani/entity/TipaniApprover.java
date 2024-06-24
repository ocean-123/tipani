//package com.example.tipani.tipani.entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class TipaniApprover {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "TIPANI_ID" ,referencedColumnName = "id")
//    private Tipani tipani;
//
//    @ManyToOne
//    @JoinColumn(name = "EMPLOYEE_ID",referencedColumnName = "id")
//    private Employee employee;
//
//    private String approverName;
//
//
//
//
//}
