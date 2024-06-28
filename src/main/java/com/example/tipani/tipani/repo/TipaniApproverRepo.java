package com.example.tipani.tipani.repo;


import com.example.tipani.tipani.entity.TipaniApprover;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TipaniApproverRepo extends JpaRepository<TipaniApprover,Long> {
    List<TipaniApprover> findByTipaniId(Long tipaniId);
}
