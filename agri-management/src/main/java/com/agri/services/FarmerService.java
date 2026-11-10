package com.agri.services;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.agri.entities.Farmer;
import com.agri.dtos.FarmerRequest;
import com.agri.repositories.FarmerRepository;
import com.agri.exceptions.ResourceNotFoundException;

@Service
@Transactional
public class FarmerService {
    private final FarmerRepository repository;

    public FarmerService(FarmerRepository repository) {
        this.repository=repository;
    }

    public Farmer create(FarmerRequest request) {
        Farmer entity = new Farmer();
        apply(entity, request);
        return repository.save(entity);
    }

    @Transactional(readOnly=true)
    public List<Farmer> findAll() { return repository.findAll(); }

    @Transactional(readOnly=true)
    public Farmer findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Farmer not found: " + id));
    }

    public Farmer update(Long id, FarmerRequest request) {
        Farmer entity = findById(id);
        apply(entity, request);
        return repository.save(entity);
    }

    public void delete(Long id) {
        Farmer entity = findById(id);
        repository.delete(entity);
    }

    private void apply(Farmer entity, FarmerRequest request) {
        entity.setName(request.getName()); entity.setPhone(request.getPhone());
        entity.setEmail(request.getEmail()); entity.setAddress(request.getAddress());
    }
}
