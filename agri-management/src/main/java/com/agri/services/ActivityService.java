package com.agri.services;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.agri.entities.Activity;
import com.agri.dtos.ActivityRequest;
import com.agri.repositories.ActivityRepository;
import com.agri.exceptions.ResourceNotFoundException;
import com.agri.repositories.CropPlanRepository;

@Service
@Transactional
public class ActivityService {
    private final ActivityRepository repository;
    private final CropPlanRepository cropPlanRepository;

    public ActivityService(ActivityRepository repository, CropPlanRepository cropPlanRepository) {
        this.repository=repository;
        this.cropPlanRepository=cropPlanRepository;
    }

    public Activity create(ActivityRequest request) {
        Activity entity = new Activity();
        apply(entity, request);
        return repository.save(entity);
    }

    @Transactional(readOnly=true)
    public List<Activity> findAll() { return repository.findAll(); }

    @Transactional(readOnly=true)
    public Activity findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Activity not found: " + id));
    }

    public Activity update(Long id, ActivityRequest request) {
        Activity entity = findById(id);
        apply(entity, request);
        return repository.save(entity);
    }

    public void delete(Long id) {
        Activity entity = findById(id);
        repository.delete(entity);
    }

    private void apply(Activity entity, ActivityRequest request) {
        entity.setCropPlan(cropPlanRepository.findById(request.getCropPlanId()).orElseThrow(() -> new ResourceNotFoundException("Crop plan not found")));
        entity.setActivityType(request.getActivityType()); entity.setActivityDate(request.getActivityDate());
        entity.setDescription(request.getDescription()); entity.setQuantity(request.getQuantity());
        entity.setQuantityUnit(request.getQuantityUnit()); entity.setCost(request.getCost());
    }
}
