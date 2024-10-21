package com.crud_equinorte_crud_equinorte_prueba.repository;

import com.crud_equinorte_crud_equinorte_prueba.model.entity.Indicador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndicadorRepository extends JpaRepository<Indicador,Long> {
}

