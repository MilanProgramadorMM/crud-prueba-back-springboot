package com.crud_equinorte_crud_equinorte_prueba.mapper;

import com.crud_equinorte_crud_equinorte_prueba.model.dto.rest_api.HistorialMedicionDTO;
import com.crud_equinorte_crud_equinorte_prueba.model.entity.HistorialMedicion;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HistorialMedicionMapper {

    public HistorialMedicionDTO convertEntityToDto(HistorialMedicion historialMedicion) {
        return HistorialMedicionDTO.builder()
                .id(historialMedicion.getId())
                .indicadorId(historialMedicion.getIndicadorId())
                .fecha(historialMedicion.getFecha())
                .valorMedido(historialMedicion.getValorMedido())
                .descripcion(historialMedicion.getDescripcion())
                .build();
    }

    public HistorialMedicion convertDtoToEntity(HistorialMedicionDTO historialMedicionDTO) {
        return HistorialMedicion.builder()
                .id(historialMedicionDTO.getId())
                .indicadorId(historialMedicionDTO.getIndicadorId())
                .fecha(historialMedicionDTO.getFecha())
                .valorMedido(historialMedicionDTO.getValorMedido())
                .descripcion(historialMedicionDTO.getDescripcion())
                .build();
    }

    public List<HistorialMedicionDTO> convertEntityListToDtoList(List<HistorialMedicion> historialMedicionList) {
        List<HistorialMedicionDTO> historialMedicionDTOList = new ArrayList<>();
        historialMedicionList.forEach(
                item -> historialMedicionDTOList.add(convertEntityToDto(item))
        );
        return historialMedicionDTOList;
    }
}
