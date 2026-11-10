package com.agri.services;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.agri.entities.Farm;
import com.agri.dtos.FarmRequest;
import com.agri.repositories.FarmRepository;
import com.agri.exceptions.ResourceNotFoundException;
import com.agri.repositories.FarmerRepository;

@Service
@Transactional
public class FarmService {
    private final FarmRepository repository;
    private final FarmerRepository farmerRepository;

    public FarmService(FarmRepository repository, FarmerRepository farmerRepository) {
        this.repository=repository;
        this.farmerRepository=farmerRepository;
    }

    public Farm create(FarmRequest request) {
        Farm entity = new Farm();
        apply(entity, request);
        return repository.save(entity);
    }

    @Transactional(readOnly=true)
    public List<Farm> findAll() { return repository.findAll(); }

    @Transactional(readOnly=true)
    public Farm findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Farm not found: " + id));
    }

    public Farm update(Long id, FarmRequest request) {
        Farm entity = findById(id);
        apply(entity, request);
        return repository.save(entity);
    }

    public void delete(Long id) {
        Farm entity = findById(id);
        repository.delete(entity);
    }

    private void apply(Farm entity, FarmRequest request) {
        entity.setFarmName(request.getFarmName()); entity.setLocation(request.getLocation());
        entity.setArea(request.getArea()); entity.setAreaUnit(request.getAreaUnit());
        entity.setOwnershipType(request.getOwnershipType());
        entity.setFarmer(farmerRepository.findById(request.getFarmerId()).orElseThrow(() -> new ResourceNotFoundException("Farmer not found")));
    }
}
