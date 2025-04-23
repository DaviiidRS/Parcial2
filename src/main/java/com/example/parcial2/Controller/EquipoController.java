package com.example.parcial2.Controller;

import com.example.parcial2.Model.Equipo;
import com.example.parcial2.Service.EquipoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equipo")
@RequiredArgsConstructor
public class EquipoController {
    private final EquipoService equipoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Equipo>> listar(){
        List<Equipo> equipos = equipoService.listar();
        return ResponseEntity.ok(equipos);
    }
    @GetMapping("/buscar/{id_equipo}")
    public ResponseEntity<Object> buscar(@PathVariable Long id_equipo){
        Optional<Equipo> cliente = equipoService.buscar(id_equipo);
        if(cliente.isPresent()){
            return ResponseEntity.ok(cliente.get());
        } else {
            return ResponseEntity.status(404)
                    .body("No se encontró el equipo con ID: " + id_equipo);
        }
    }
    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody Equipo equipo){
        try {
            equipoService.guardar(equipo);
            return ResponseEntity.ok("Equipo guardado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al guardar el equipo: " + e.getMessage());
        }
    }
    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody Equipo equipo){
        try {
            equipoService.actualizar(equipo);
            return ResponseEntity.ok("Equipo actualizado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar el equipo: " + e.getMessage());
        }
    }
    @DeleteMapping("/eliminar/{id_equipo}")
    public ResponseEntity<?> eliminar(@PathVariable Long id_equipo){
        try {
            equipoService.eliminar(id_equipo);
            return ResponseEntity.ok("Equipo eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al eliminar el equipo: " + e.getMessage());
        }
    }
}
