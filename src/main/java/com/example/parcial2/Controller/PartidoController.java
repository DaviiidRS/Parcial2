package com.example.parcial2.Controller;

import com.example.parcial2.Model.Partido;
import com.example.parcial2.Service.PartidoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/partido")
@RequiredArgsConstructor
public class PartidoController {
    private final PartidoService partidoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Partido>> listar(){
        List<Partido> partidos = partidoService.listar();
        return ResponseEntity.ok(partidos);
    }

    @GetMapping("/buscar/{id_partido}")
    public ResponseEntity<Object> buscar(@PathVariable Long id_partido){
        Optional<Partido> partido = Optional.ofNullable(partidoService.buscar(id_partido));
        if(partido.isPresent()){
            return ResponseEntity.ok(partido.get());
        } else {
            return ResponseEntity.status(404)
                    .body("No se encontró el partido con ID: " + id_partido);
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody Partido partido){
        try {
            partidoService.guardar(partido);
            return ResponseEntity.ok("Partido guardado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al guardar el partido: " + e.getMessage());
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody Partido partido){
        try {
            partidoService.actualizar(partido);
            return ResponseEntity.ok("Partido actualizado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar el partido: " + e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id_partido}")
    public ResponseEntity<?> eliminar(@PathVariable Long id_partido){
        try {
            partidoService.eliminar(id_partido);
            return ResponseEntity.ok("Partido eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al eliminar el partido: " + e.getMessage());
        }
    }
}
