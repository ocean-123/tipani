package com.example.tipani.tipani.repo;

import com.example.tipani.tipani.entity.TipaniRecomendators;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TipaniRecomendatorsRepo extends JpaRepository<TipaniRecomendators,Long> {
    List<TipaniRecomendators> findByTipaniId(Long tipaniId);
}
