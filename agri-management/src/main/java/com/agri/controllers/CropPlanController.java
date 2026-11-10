package com.agri.controllers;

import java.util.List;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.agri.entities.CropPlan;
import com.agri.dtos.CropPlanRequest;
import com.agri.services.CropPlanService;

@RestController
@RequestMapping("/api/crop-plans")
public class CropPlanController {
    private final CropPlanService service;
    public CropPlanController(CropPlanService service) { this.service=service; }

    @PostMapping
    public ResponseEntity<CropPlan> create(@Valid @RequestBody CropPlanRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<CropPlan>> findAll() { return ResponseEntity.ok(service.findAll()); }

    @GetMapping("/{id}")
    public ResponseEntity<CropPlan> findById(@PathVariable Long id) { return ResponseEntity.ok(service.findById(id)); }

    @PutMapping("/{id}")
    public ResponseEntity<CropPlan> update(@PathVariable Long id, @Valid @RequestBody CropPlanRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id); return ResponseEntity.noContent().build();
    }
}
