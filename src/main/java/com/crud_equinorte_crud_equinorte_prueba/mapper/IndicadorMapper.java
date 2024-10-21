package com.crud_equinorte_crud_equinorte_prueba.mapper;

import com.crud_equinorte_crud_equinorte_prueba.model.dto.rest_api.IndicadorDTO;
import com.crud_equinorte_crud_equinorte_prueba.model.entity.Indicador;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class IndicadorMapper {

    // Convertir de Entidad a DTO
    public IndicadorDTO convertEntityToDto(Indicador indicador) {
        return IndicadorDTO.builder()
                .id(indicador.getId())
                .nombre(indicador.getNombre())
                .valorMinimo(indicador.getValorMinimo())
                .valorEsperado(indicador.getValorEsperado())
                .valorMaximo(indicador.getValorMaximo())
                .build();
    }

    // Convertir de DTO a Entidad
    public Indicador convertDtoToEntity(IndicadorDTO indicadorDTO) {
        return Indicador.builder()
                .id(indicadorDTO.getId())
                .nombre(indicadorDTO.getNombre())
                .valorMinimo(indicadorDTO.getValorMinimo())
                .valorEsperado(indicadorDTO.getValorEsperado())
                .valorMaximo(indicadorDTO.getValorMaximo())
                .build();
    }

    // Convertir una lista de Entidades a una lista de DTOs
    public List<IndicadorDTO> convertEntityListToDtoList(List<Indicador> indicadorList) {
        List<IndicadorDTO> indicadorDTOList = new ArrayList<>();
        indicadorList.forEach(
                item -> indicadorDTOList.add(IndicadorDTO.builder()
                        .id(item.getId())
                        .nombre(item.getNombre())
                        .valorMinimo(item.getValorMinimo())
                        .valorEsperado(item.getValorEsperado())
                        .valorMaximo(item.getValorMaximo())
                        .build())
        );
        return indicadorDTOList;
    }
}
