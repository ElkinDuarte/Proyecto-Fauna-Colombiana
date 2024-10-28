package com.example.fauna_colombiana1.controller;

import com.example.fauna_colombiana1.model.TmHabitat;
import com.example.fauna_colombiana1.service.TmHabitatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habitats")
public class HabitatController {
    private final TmHabitatService service;

    public HabitatController(TmHabitatService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TmHabitat>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TmHabitat> getById(@PathVariable Integer id) {
        TmHabitat habitat = service.findById(id);
        if (habitat == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(habitat);
    }

    @PostMapping
    public ResponseEntity<TmHabitat> create(@RequestBody TmHabitat habitat) {
        return ResponseEntity.ok(service.save(habitat));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TmHabitat> update(@PathVariable Integer id, @RequestBody TmHabitat habitat) {
        TmHabitat existing = service.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(service.save(habitat));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}