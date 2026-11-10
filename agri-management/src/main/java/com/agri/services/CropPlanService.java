package com.agri.services;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.agri.entities.CropPlan;
import com.agri.dtos.CropPlanRequest;
import com.agri.repositories.CropPlanRepository;
import com.agri.exceptions.ResourceNotFoundException;
import com.agri.repositories.FieldRepository;
import com.agri.repositories.CropRepository;

@Service
@Transactional
public class CropPlanService {
    private final CropPlanRepository repository;
    private final FieldRepository fieldRepository;
    private final CropRepository cropRepository;

    public CropPlanService(CropPlanRepository repository, FieldRepository fieldRepository, CropRepository cropRepository) {
        this.repository=repository;
        this.fieldRepository=fieldRepository; this.cropRepository=cropRepository;
    }

    public CropPlan create(CropPlanRequest request) {
        CropPlan entity = new CropPlan();
        apply(entity, request);
        return repository.save(entity);
    }

    @Transactional(readOnly=true)
    public List<CropPlan> findAll() { return repository.findAll(); }

    @Transactional(readOnly=true)
    public CropPlan findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CropPlan not found: " + id));
    }

    public CropPlan update(Long id, CropPlanRequest request) {
        CropPlan entity = findById(id);
        apply(entity, request);
        return repository.save(entity);
    }

    public void delete(Long id) {
        CropPlan entity = findById(id);
        repository.delete(entity);
    }

    private void apply(CropPlan entity, CropPlanRequest request) {
        entity.setField(fieldRepository.findById(request.getFieldId()).orElseThrow(() -> new ResourceNotFoundException("Field not found")));
        entity.setCrop(cropRepository.findById(request.getCropId()).orElseThrow(() -> new ResourceNotFoundException("Crop not found")));
        entity.setSeason(request.getSeason()); entity.setSowingDate(request.getSowingDate());
        entity.setExpectedHarvestDate(request.getExpectedHarvestDate()); entity.setStatus(request.getStatus());
    }
}
