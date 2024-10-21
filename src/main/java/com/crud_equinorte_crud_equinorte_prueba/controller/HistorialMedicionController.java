package com.crud_equinorte_crud_equinorte_prueba.controller;

import com.crud_equinorte_crud_equinorte_prueba.model.dto.rest_api.HistorialMedicionDTO;
import com.crud_equinorte_crud_equinorte_prueba.service.HistorialMedicionService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/mediciones")
public class HistorialMedicionController {

    @Autowired
    private HistorialMedicionService historialMedicionService;

    @GetMapping("/get")
    public List<HistorialMedicionDTO> getAllMediciones() {
        return historialMedicionService.obtenerTodo();
    }

    @GetMapping("/{id}")
    public HistorialMedicionDTO getMedicionById(@PathVariable("id") Long id) throws BadRequestException {
        return historialMedicionService.obtenerPorId(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody HistorialMedicionDTO historialMedicionDTO) {
        Map<String, Object> map = new HashMap<>();
        try {
            HistorialMedicionDTO data = historialMedicionService.guardar(historialMedicionDTO);
            map.put("data", data);
            map.put("success", true);
            map.put("message", "Medición creada correctamente");
            return ResponseEntity.ok(map);
        } catch (Exception e) {
            map.put("statusCode", HttpStatus.BAD_REQUEST.value());
            map.put("message", e.getMessage());
            map.put("success", false);
            return ResponseEntity.badRequest().body(map);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<HistorialMedicionDTO> actualizar(@PathVariable("id") Long id, @RequestBody HistorialMedicionDTO historialMedicionDTO) throws BadRequestException {
        historialMedicionDTO.setId(id);
        HistorialMedicionDTO data = historialMedicionService.actualizar(historialMedicionDTO);
        if (data == null) {
            throw new BadRequestException("No se pudo actualizar la medición con ID: " + id);
        }
        return ResponseEntity.ok(data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicion(@PathVariable Long id) {
        historialMedicionService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
