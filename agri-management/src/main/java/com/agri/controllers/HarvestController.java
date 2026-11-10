package com.agri.controllers;

import java.util.List;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.agri.entities.Harvest;
import com.agri.dtos.HarvestRequest;
import com.agri.services.HarvestService;

@RestController
@RequestMapping("/api/harvests")
public class HarvestController {
    private final HarvestService service;
    public HarvestController(HarvestService service) { this.service=service; }

    @PostMapping
    public ResponseEntity<Harvest> create(@Valid @RequestBody HarvestRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<Harvest>> findAll() { return ResponseEntity.ok(service.findAll()); }

    @GetMapping("/{id}")
    public ResponseEntity<Harvest> findById(@PathVariable Long id) { return ResponseEntity.ok(service.findById(id)); }

    @PutMapping("/{id}")
    public ResponseEntity<Harvest> update(@PathVariable Long id, @Valid @RequestBody HarvestRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id); return ResponseEntity.noContent().build();
    }
}
