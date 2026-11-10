package com.agri.controllers;

import java.util.List;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.agri.entities.Field;
import com.agri.dtos.FieldRequest;
import com.agri.services.FieldService;

@RestController
@RequestMapping("/api/fields")
public class FieldController {
    private final FieldService service;
    public FieldController(FieldService service) { this.service=service; }

    @PostMapping
    public ResponseEntity<Field> create(@Valid @RequestBody FieldRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<Field>> findAll() { return ResponseEntity.ok(service.findAll()); }

    @GetMapping("/{id}")
    public ResponseEntity<Field> findById(@PathVariable Long id) { return ResponseEntity.ok(service.findById(id)); }

    @PutMapping("/{id}")
    public ResponseEntity<Field> update(@PathVariable Long id, @Valid @RequestBody FieldRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id); return ResponseEntity.noContent().build();
    }
}
