package com.example.tipani.tipani.repo;

import com.example.tipani.tipani.entity.Tipani;
import com.example.tipani.tipani.entity.TipaniStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TipaniRepo extends JpaRepository<Tipani,Long> {
    List<Tipani> findByStatus(TipaniStatus status);


    List<Tipani> findByEmployeeId(Long employeeId);
}
