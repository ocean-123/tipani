package com.example.tipani.tipani.repo;

import com.example.tipani.tipani.entity.TipaniComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TipaniCommnetRepo extends JpaRepository<TipaniComment,Long> {
    List<TipaniComment> findByTipaniId(Long tipaniId);
}
