package com.example.fauna_colombiana1.repository;

import com.example.fauna_colombiana1.model.TmHabitat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitatRepository extends JpaRepository<TmHabitat, Integer> {
}