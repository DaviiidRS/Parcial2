package com.example.parcial2.Controller;

import com.example.parcial2.Model.Entrenador;
import com.example.parcial2.Service.EntrenadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/entrenador")
@RequiredArgsConstructor
public class EntrenadorController {
    private final EntrenadorService entrenadorService;

    @GetMapping("/listar")
    public ResponseEntity<List<Entrenador>> listar(){
        List<Entrenador> entrenadores = entrenadorService.listar();
        return ResponseEntity.ok(entrenadores);
    }

    @GetMapping("/buscar/{id_entrenador}")
    public ResponseEntity<Object> buscar(@PathVariable Long id_entrenador){
        Optional<Entrenador> entrenador = entrenadorService.buscar(id_entrenador);
        if(entrenador.isPresent()){
            return ResponseEntity.ok(entrenador);
        } else {
            return ResponseEntity.status(404)
                    .body("No se encontró el entrenador con ID: " + id_entrenador);
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody Entrenador entrenador){
        try {
            entrenadorService.guardar(entrenador);
            return ResponseEntity.ok("Entrenador guardado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al guardar el entrenador: " + e.getMessage());
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody Entrenador entrenador){
        try {
            entrenadorService.actualizar(entrenador);
            return ResponseEntity.ok("Entrenador actualizado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar el entrenador: " + e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id_entrenador}")
    public ResponseEntity<?> eliminar(@PathVariable Long id_entrenador){
        try {
            entrenadorService.eliminar(id_entrenador);
            return ResponseEntity.ok("Entrenador eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al eliminar el entrenador: " + e.getMessage());
        }
    }
}
