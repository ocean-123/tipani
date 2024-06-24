package com.example.tipani.tipani.service.impl;

import com.example.tipani.tipani.entity.*;
import com.example.tipani.tipani.entity.dto.EmployeeDTO;
import com.example.tipani.tipani.entity.dto.TipaniAttachmentDTO;
import com.example.tipani.tipani.entity.dto.TipaniDTO;
import com.example.tipani.tipani.entity.dto.TipaniRecomendatorsDTO;
import com.example.tipani.tipani.repo.DepartmentRepo;
import com.example.tipani.tipani.repo.DocumentTypesRepo;
import com.example.tipani.tipani.repo.TipaniAttachmentRepo;
import com.example.tipani.tipani.repo.TipaniRepo;
import com.example.tipani.tipani.service.TipaniAttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TipaniAttachServiceImpl implements TipaniAttachService {
    @Autowired
    private TipaniAttachmentRepo repository;

    @Autowired
    private TipaniRepo tipaniRepo;

    @Autowired
    private DocumentTypesRepo typesRepo;
    public TipaniAttachmentDTO saveEntity(TipaniAttachment entity) {
        TipaniAttachment savedEmployee = repository.save(entity);
        return new TipaniAttachmentDTO(savedEmployee);
    }

    public List<TipaniAttachmentDTO> getAllEntities() {
        return repository.findAll().stream()
                .map(TipaniAttachmentDTO::new)
                .collect(Collectors.toList());
    }

    public Optional<TipaniAttachmentDTO> getEntityById(Long id) {
        return repository.findById(id)
                .map(TipaniAttachmentDTO::new);
    }

    @Override
    public TipaniAttachmentDTO updateTipaniAttach(Long id, TipaniAttachmentDTO attachmentDTO) throws ResourceNotFoundException {

        TipaniAttachment attachment = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Could not find attachment"+id));

        attachment.setId(attachmentDTO.getId());


        if (attachmentDTO.getTipaniId() != null) {
            Tipani tipani = tipaniRepo.findById(attachmentDTO.getTipaniId())
                    .orElseThrow(() -> new ResourceNotFoundException("Tipani not found with id " + attachmentDTO.getTipaniId()));
            attachment.setTipani(tipani);
        }
        if (attachmentDTO.getDocumentTypesId() != null) {
            DocumentTypes types = typesRepo.findById(attachmentDTO.getDocumentTypesId())
                    .orElseThrow(() -> new ResourceNotFoundException("employee not found with id " + attachmentDTO.getDocumentTypesId()));
            attachment.setDocumentTypes(types);
        }
        attachment.setAttachmentLocation(attachmentDTO.getAttachmentLocation());
        attachment.setFileLocation(attachmentDTO.getFileLocation());
        attachment.setFileName(attachmentDTO.getFileName());

        attachment.setCreatedName(attachmentDTO.getCreatedName());
        attachment.setCreatedDate(attachmentDTO.getCreatedDate());
        attachment.setUpdateName(attachmentDTO.getUpdateName());
        attachment.setUpdateDate(attachmentDTO.getUpdateDate());

        TipaniAttachment attachment1 = repository.save(attachment);

        return new TipaniAttachmentDTO(attachment1);


    }


    public void deleteEntity(Long id) {
        repository.deleteById(id);
    }

    public TipaniAttachment updateStatus(Long id, boolean status) {
        Optional<TipaniAttachment> optionalEntity = repository.findById(id);
        if (optionalEntity.isPresent()) {
            TipaniAttachment entity = optionalEntity.get();
//            entity.setStatus(status);
            return repository.save(entity);
        } else {
            throw new RuntimeException("Entity not found");
        }
    }
}
