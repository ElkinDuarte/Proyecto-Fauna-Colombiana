package com.example.fauna_colombiana1.controller;

import com.example.fauna_colombiana1.model.TmAnimal;
import com.example.fauna_colombiana1.service.AnimalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animales")
public class AnimalController {
    private final AnimalService service;

    public AnimalController(AnimalService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TmAnimal>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TmAnimal> getById(@PathVariable Integer id) {
        TmAnimal animal = service.findById(id);
        if (animal == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(animal);
    }

    @PostMapping
    public ResponseEntity<TmAnimal> create(@RequestBody TmAnimal animal) {
        return ResponseEntity.ok(service.save(animal));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TmAnimal> update(@PathVariable Integer id, @RequestBody TmAnimal animal) {
        TmAnimal existing = service.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(service.save(animal));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}