package com.example.fauna_colombiana1.controller;

import com.example.fauna_colombiana1.model.TdCaracteristicas;
import com.example.fauna_colombiana1.service.TdCaracteristicasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/caracteristicas")
public class CaracteristicasController {
    private final TdCaracteristicasService service;

    public CaracteristicasController(TdCaracteristicasService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TdCaracteristicas>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TdCaracteristicas> getById (@PathVariable Integer id) {
        TdCaracteristicas caracteristicas = service.findById(id);
        if (caracteristicas == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(caracteristicas);
    }

    @PostMapping
    public ResponseEntity<TdCaracteristicas> create(@RequestBody TdCaracteristicas caracteristicas) {
        return ResponseEntity.ok(service.save(caracteristicas));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TdCaracteristicas> update(@PathVariable Integer id, @RequestBody TdCaracteristicas caracteristicas) {
        TdCaracteristicas existing = service.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(service.save(caracteristicas));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}