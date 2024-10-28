package com.example.fauna_colombiana1.service;

import com.example.fauna_colombiana1.model.TdTipoAnimal;
import com.example.fauna_colombiana1.repository.TipoAnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoAnimalService {

    private final TipoAnimalRepository repository;

    public TipoAnimalService(TipoAnimalRepository repository) {
        this.repository = repository;
    }

    /**
     * Obtiene todos los tipos de animales.
     * @return lista de tipos de animales
     */
    public List<TdTipoAnimal> findAll() {
        return repository.findAll();
    }

    /**
     * Busca un tipo de animal por su ID.
     * @param id Identificador del tipo de animal
     * @return el tipo de animal encontrado o null si no existe
     */
    public TdTipoAnimal findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * Guarda un nuevo tipo de animal o actualiza uno existente.
     * @param tipoAnimal Objeto TdTipoAnimal a guardar
     * @return el tipo de animal guardado
     */
    public TdTipoAnimal save(TdTipoAnimal tipoAnimal) {
        return repository.save(tipoAnimal);
    }

    /**
     * Elimina un tipo de animal por su ID.
     * @param id Identificador del tipo de animal a eliminar
     */
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
