package com.crud_equinorte_crud_equinorte_prueba.service;

import com.crud_equinorte_crud_equinorte_prueba.mapper.HistorialMedicionMapper;
import com.crud_equinorte_crud_equinorte_prueba.model.dto.rest_api.HistorialMedicionDTO;
import com.crud_equinorte_crud_equinorte_prueba.model.entity.HistorialMedicion;
import com.crud_equinorte_crud_equinorte_prueba.repository.HistorialRepository;
import com.crud_equinorte_crud_equinorte_prueba.repository.IndicadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.coyote.BadRequestException;

import java.util.List;
import java.util.Optional;

@Service
public class HistorialMedicionService {

    @Autowired
    private HistorialRepository historialMedicionRepository;

    @Autowired
    private IndicadorRepository indicadorRepository;

    @Autowired
    private HistorialMedicionMapper historialMedicionMapper;

    public List<HistorialMedicionDTO> obtenerTodo() {
        return historialMedicionMapper.convertEntityListToDtoList(historialMedicionRepository.findAll());
    }

    public HistorialMedicionDTO obtenerPorId(Long id) throws BadRequestException {
        Optional<HistorialMedicion> historialMedicion = historialMedicionRepository.findById(id);
        if (historialMedicion.isEmpty()) {
            throw new BadRequestException(String.format("No se encontró medición con el ID %s", id));
        }
        return historialMedicionMapper.convertEntityToDto(historialMedicion.get());
    }

    public HistorialMedicionDTO guardar(HistorialMedicionDTO historialMedicionDTO) throws BadRequestException {
        // Verificar si el indicador existe
        if (!indicadorRepository.existsById(historialMedicionDTO.getIndicadorId())) {
            throw new BadRequestException("El indicador no existe");
        }

        HistorialMedicion historialMedicion = historialMedicionMapper.convertDtoToEntity(historialMedicionDTO);
        historialMedicion = historialMedicionRepository.save(historialMedicion);
        return historialMedicionMapper.convertEntityToDto(historialMedicion);
    }

    public HistorialMedicionDTO actualizar(HistorialMedicionDTO historialMedicionDTO) throws BadRequestException {
        // Verificar si la medición existe
        HistorialMedicionDTO existMedicion = obtenerPorId(historialMedicionDTO.getId());

        if (existMedicion == null) {
            return null;
        }

        // Actualizar los campos de la medición existente
        existMedicion.setFecha(historialMedicionDTO.getFecha());
        existMedicion.setValorMedido(historialMedicionDTO.getValorMedido());
        existMedicion.setDescripcion(historialMedicionDTO.getDescripcion());

        HistorialMedicion historialMedicion = historialMedicionMapper.convertDtoToEntity(existMedicion);
        historialMedicion = historialMedicionRepository.save(historialMedicion);

        return historialMedicionMapper.convertEntityToDto(historialMedicion);
    }

    public void eliminarPorId(Long id) {
        historialMedicionRepository.deleteById(id);
    }
}
