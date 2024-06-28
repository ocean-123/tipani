package com.example.tipani.tipani.repo;

import com.example.tipani.tipani.entity.TipaniAttachment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TipaniAttachmentRepo extends JpaRepository<TipaniAttachment,Long> {
    List<TipaniAttachment> findByTipaniId(Long tipaniId);
}
