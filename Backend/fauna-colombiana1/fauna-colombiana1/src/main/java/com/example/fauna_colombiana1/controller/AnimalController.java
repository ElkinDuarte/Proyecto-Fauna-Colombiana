package com.example.fauna_colombiana1.controller;

import com.example.fauna_colombiana1.model.TmAnimal;
import com.example.fauna_colombiana1.service.AnimalService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/animales")
public class AnimalController {
    private final AnimalService service;

    public AnimalController(AnimalService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<TmAnimal>> getAll(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "12") int size) {
    Pageable pageable = PageRequest.of(page, size);
    Page<TmAnimal> animales = service.findAll(pageable);
    return ResponseEntity.ok(animales);
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