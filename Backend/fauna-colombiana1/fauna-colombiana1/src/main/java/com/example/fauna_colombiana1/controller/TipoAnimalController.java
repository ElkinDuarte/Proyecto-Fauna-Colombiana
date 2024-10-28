package com.example.fauna_colombiana1.controller;

import com.example.fauna_colombiana1.model.TdTipoAnimal;
import com.example.fauna_colombiana1.service.TipoAnimalService; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-animal")
public class TipoAnimalController {
    private final TipoAnimalService service;

    public TipoAnimalController(TipoAnimalService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TdTipoAnimal>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TdTipoAnimal> getById(@PathVariable Integer id) {
        TdTipoAnimal tipoAnimal = service.findById(id);
        if (tipoAnimal == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tipoAnimal);
    }

    @PostMapping
    public ResponseEntity<TdTipoAnimal> create(@RequestBody TdTipoAnimal tipoAnimal) {
        return ResponseEntity.ok(service.save(tipoAnimal));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TdTipoAnimal> update(@PathVariable Integer id, @RequestBody TdTipoAnimal tipoAnimal) {
        TdTipoAnimal existing = service.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(service.save(tipoAnimal));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}