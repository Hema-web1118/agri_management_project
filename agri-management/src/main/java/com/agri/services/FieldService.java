package com.agri.services;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.agri.entities.Field;
import com.agri.dtos.FieldRequest;
import com.agri.repositories.FieldRepository;
import com.agri.exceptions.ResourceNotFoundException;
import com.agri.repositories.FarmRepository;

@Service
@Transactional
public class FieldService {
    private final FieldRepository repository;
    private final FarmRepository farmRepository;

    public FieldService(FieldRepository repository, FarmRepository farmRepository) {
        this.repository=repository;
        this.farmRepository=farmRepository;
    }

    public Field create(FieldRequest request) {
        Field entity = new Field();
        apply(entity, request);
        return repository.save(entity);
    }

    @Transactional(readOnly=true)
    public List<Field> findAll() { return repository.findAll(); }

    @Transactional(readOnly=true)
    public Field findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Field not found: " + id));
    }

    public Field update(Long id, FieldRequest request) {
        Field entity = findById(id);
        apply(entity, request);
        return repository.save(entity);
    }

    public void delete(Long id) {
        Field entity = findById(id);
        repository.delete(entity);
    }

    private void apply(Field entity, FieldRequest request) {
        entity.setFieldName(request.getFieldName()); entity.setArea(request.getArea()); entity.setSoilType(request.getSoilType());
        entity.setFarm(farmRepository.findById(request.getFarmId()).orElseThrow(() -> new ResourceNotFoundException("Farm not found")));
    }
}
