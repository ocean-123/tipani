package com.example.tipani.tipani.repo;

import com.example.tipani.tipani.entity.TipaniComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipaniCommnetRepo extends JpaRepository<TipaniComment,Long> {
        }
