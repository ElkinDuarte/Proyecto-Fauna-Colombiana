package com.example.fauna_colombiana1.service;

import com.example.fauna_colombiana1.model.TmHabitat;
import com.example.fauna_colombiana1.repository.HabitatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TmHabitatService {

    private final HabitatRepository repository;

    public TmHabitatService(HabitatRepository repository) {
        this.repository = repository;
    }

    /**
     * Obtiene todos los hábitats.
     * @return lista de hábitats
     */
    public List<TmHabitat> findAll() {
        return repository.findAll();
    }

    /**
     * Busca un hábitat por su ID.
     * @param id Identificador del hábitat
     * @return el hábitat encontrado o null si no existe
     */
    public TmHabitat findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * Guarda un nuevo hábitat o actualiza uno existente.
     * @param habitat Objeto TmHabitat a guardar
     * @return el hábitat guardado
     */
    public TmHabitat save(TmHabitat habitat) {
        return repository.save(habitat);
    }

    /**
     * Elimina un hábitat por su ID.
     * @param id Identificador del hábitat a eliminar
     */
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
