package com.example.fauna_colombiana1.service;

import com.example.fauna_colombiana1.model.TdCaracteristicas;
import com.example.fauna_colombiana1.repository.CaracteristicasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TdCaracteristicasService {

    private final CaracteristicasRepository repository;

    public TdCaracteristicasService(CaracteristicasRepository repository) {
        this.repository = repository;
    }

    /**
     * Obtiene todas las características.
     * @return lista de características
     */
    public List<TdCaracteristicas> findAll() {
        return repository.findAll();
    }

    /**
     * Busca una característica por su ID.
     * @param id Identificador de la característica
     * @return la característica encontrada o null si no existe
     */
    public TdCaracteristicas findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * Guarda una nueva característica o actualiza una existente.
     * @param caracteristicas Objeto TdCaracteristicas a guardar
     * @return la característica guardada
     */
    public TdCaracteristicas save(TdCaracteristicas caracteristicas) {
        return repository.save(caracteristicas);
    }

    /**
     * Elimina una característica por su ID.
     * @param id Identificador de la característica a eliminar
     */
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
