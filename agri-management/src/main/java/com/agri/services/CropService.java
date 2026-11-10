package com.agri.services;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.agri.entities.Crop;
import com.agri.dtos.CropRequest;
import com.agri.repositories.CropRepository;
import com.agri.exceptions.ResourceNotFoundException;

@Service
@Transactional
public class CropService {
    private final CropRepository repository;

    public CropService(CropRepository repository) {
        this.repository=repository;
    }

    public Crop create(CropRequest request) {
        Crop entity = new Crop();
        apply(entity, request);
        return repository.save(entity);
    }

    @Transactional(readOnly=true)
    public List<Crop> findAll() { return repository.findAll(); }

    @Transactional(readOnly=true)
    public Crop findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Crop not found: " + id));
    }

    public Crop update(Long id, CropRequest request) {
        Crop entity = findById(id);
        apply(entity, request);
        return repository.save(entity);
    }

    public void delete(Long id) {
        Crop entity = findById(id);
        repository.delete(entity);
    }

    private void apply(Crop entity, CropRequest request) {
        entity.setCropName(request.getCropName()); entity.setVariety(request.getVariety());
        entity.setDescription(request.getDescription()); entity.setExpectedDurationDays(request.getExpectedDurationDays());
    }
}
