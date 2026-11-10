package com.agri.services;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.agri.entities.Expense;
import com.agri.dtos.ExpenseRequest;
import com.agri.repositories.ExpenseRepository;
import com.agri.exceptions.ResourceNotFoundException;
import com.agri.repositories.FarmRepository;
import com.agri.repositories.FieldRepository;

@Service
@Transactional
public class ExpenseService {
    private final ExpenseRepository repository;
    private final FarmRepository farmRepository;
    private final FieldRepository fieldRepository;

    public ExpenseService(ExpenseRepository repository, FarmRepository farmRepository, FieldRepository fieldRepository) {
        this.repository=repository;
        this.farmRepository=farmRepository; this.fieldRepository=fieldRepository;
    }

    public Expense create(ExpenseRequest request) {
        Expense entity = new Expense();
        apply(entity, request);
        return repository.save(entity);
    }

    @Transactional(readOnly=true)
    public List<Expense> findAll() { return repository.findAll(); }

    @Transactional(readOnly=true)
    public Expense findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Expense not found: " + id));
    }

    public Expense update(Long id, ExpenseRequest request) {
        Expense entity = findById(id);
        apply(entity, request);
        return repository.save(entity);
    }

    public void delete(Long id) {
        Expense entity = findById(id);
        repository.delete(entity);
    }

    private void apply(Expense entity, ExpenseRequest request) {
        entity.setFarm(farmRepository.findById(request.getFarmId()).orElseThrow(() -> new ResourceNotFoundException("Farm not found")));
        entity.setField(request.getFieldId()==null ? null : fieldRepository.findById(request.getFieldId()).orElseThrow(() -> new ResourceNotFoundException("Field not found")));
        entity.setCategory(request.getCategory()); entity.setAmount(request.getAmount());
        entity.setExpenseDate(request.getExpenseDate()); entity.setDescription(request.getDescription());
    }
}
