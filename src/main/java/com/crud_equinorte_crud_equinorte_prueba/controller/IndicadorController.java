package com.crud_equinorte_crud_equinorte_prueba.controller;


import com.crud_equinorte_crud_equinorte_prueba.model.dto.rest_api.IndicadorDTO;
import com.crud_equinorte_crud_equinorte_prueba.service.IndicadorService;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/indicadores")
public class IndicadorController {

    @Autowired
    private IndicadorService indicadorService;

    @GetMapping("get")
    public List<IndicadorDTO> getAllIndicadores() {
        return indicadorService.ObtenerTodo();
    }

    @GetMapping("/{id}")
    public IndicadorDTO getIndicatorById(@PathVariable ("id") Long id) throws BadRequestException {
        if(!indicadorService.existsByIdIndicador(id))
            throw new BadRequestException("No existe un registro con este id " + id);

        return indicadorService.obtenerPorId(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody @Valid IndicadorDTO indicadorDTO, BindingResult
            bindingResult) throws Exception {
        if (bindingResult.hasErrors())
            throw new RuntimeException();
        IndicadorDTO data = null;
        Map<String, Object> map = new HashMap<>();
        try {
            data = indicadorService.guardar(indicadorDTO);
        } catch (Exception e) {
            map.put("statusCode", HttpStatus.BAD_REQUEST.value());
            map.put("message", e.getMessage());
            map.put("success", false);
            return ResponseEntity.badRequest().body(map);
        }
        map.put("message", "Carro creado correctamente");
        map.put("data", data);
        map.put("success", true);
        return ResponseEntity.ok(map);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<IndicadorDTO> actualizar(@PathVariable("id") Long id, @RequestBody IndicadorDTO indicadorDTO) throws BadRequestException {
        // Asegurar que el ID del DTO sea el mismo que el de la URL
        indicadorDTO.setId(id);

        // Intentar actualizar la persona
        IndicadorDTO data = indicadorService.actualizar(indicadorDTO);

        if (data == null) {
            // Lanzar una excepción si no se encuentra el ID
            throw new BadRequestException("No se pudo actualizar la persona con ID: " + id);
        }

        // Devolver la respuesta con la persona actualizada
        return ResponseEntity.ok(data);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIndicador(@PathVariable Long id) {
        indicadorService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
