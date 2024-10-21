package com.crud_equinorte_crud_equinorte_prueba.service;


import com.crud_equinorte_crud_equinorte_prueba.mapper.IndicadorMapper;
import com.crud_equinorte_crud_equinorte_prueba.model.dto.rest_api.IndicadorDTO;
import com.crud_equinorte_crud_equinorte_prueba.model.entity.Indicador;
import com.crud_equinorte_crud_equinorte_prueba.repository.IndicadorRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IndicadorService {

    @Autowired
    private IndicadorRepository indicadorRepository;

    @Autowired
    IndicadorMapper indicadorMapper;

    public List<IndicadorDTO> ObtenerTodo() {
        // Obtener todas las entidades del repositorio y mapearlas a DTOs
        return indicadorMapper.convertEntityListToDtoList(indicadorRepository.findAll());
    }
    public IndicadorDTO obtenerPorId(Long id) throws BadRequestException {
        Optional<Indicador> indicador = indicadorRepository.findById(id);
        if (indicador.isEmpty())
            throw new BadRequestException(String.format("No se encontro servicio con el ID %s", id));
        return indicadorMapper.convertEntityToDto(indicador.get());
    }
    public IndicadorDTO guardar(IndicadorDTO indicadorDTO) {
        Indicador indicador = indicadorMapper.convertDtoToEntity(indicadorDTO);
        indicador = indicadorRepository.save(indicador);
        return indicadorMapper.convertEntityToDto(indicador);
    }
    public IndicadorDTO actualizar(IndicadorDTO indicadorDTO) throws BadRequestException {
        IndicadorDTO existIndicador = obtenerPorId(indicadorDTO.getId());

        if (existIndicador == null) {
            return null;
        }

        existIndicador.setNombre(indicadorDTO.getNombre());
        existIndicador.setValorMinimo(indicadorDTO.getValorMinimo());
        existIndicador.setValorEsperado(indicadorDTO.getValorEsperado());
        existIndicador.setValorEsperado(indicadorDTO.getValorEsperado());

        Indicador indicador = indicadorMapper.convertDtoToEntity(existIndicador);
        indicador = indicadorRepository.save(indicador);

        return indicadorMapper.convertEntityToDto(indicador);
    }

    public void eliminarPorId(Long id) {
        indicadorRepository.deleteById(id);
    }

    public boolean existsByIdIndicador(Long idIndicador) {
        return indicadorRepository.existsById(idIndicador);
    }
}
