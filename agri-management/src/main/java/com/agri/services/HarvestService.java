package com.agri.services;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.agri.entities.Harvest;
import com.agri.dtos.HarvestRequest;
import com.agri.repositories.HarvestRepository;
import com.agri.exceptions.ResourceNotFoundException;
import com.agri.repositories.CropPlanRepository;

@Service
@Transactional
public class HarvestService {
    private final HarvestRepository repository;
    private final CropPlanRepository cropPlanRepository;

    public HarvestService(HarvestRepository repository, CropPlanRepository cropPlanRepository) {
        this.repository=repository;
        this.cropPlanRepository=cropPlanRepository;
    }

    public Harvest create(HarvestRequest request) {
        Harvest entity = new Harvest();
        apply(entity, request);
        return repository.save(entity);
    }

    @Transactional(readOnly=true)
    public List<Harvest> findAll() { return repository.findAll(); }

    @Transactional(readOnly=true)
    public Harvest findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Harvest not found: " + id));
    }

    public Harvest update(Long id, HarvestRequest request) {
        Harvest entity = findById(id);
        apply(entity, request);
        return repository.save(entity);
    }

    public void delete(Long id) {
        Harvest entity = findById(id);
        repository.delete(entity);
    }

    private void apply(Harvest entity, HarvestRequest request) {
        entity.setCropPlan(cropPlanRepository.findById(request.getCropPlanId()).orElseThrow(() -> new ResourceNotFoundException("Crop plan not found")));
        entity.setHarvestDate(request.getHarvestDate()); entity.setQuantity(request.getQuantity());
        entity.setQuantityUnit(request.getQuantityUnit()); entity.setQuality(request.getQuality());
        entity.setSellingPricePerUnit(request.getSellingPricePerUnit());
        if (request.getSellingPricePerUnit()!=null) entity.setTotalRevenue(request.getQuantity().multiply(request.getSellingPricePerUnit()));
    }
}
