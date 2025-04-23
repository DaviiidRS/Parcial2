package com.example.parcial2.Controller;

import com.example.parcial2.Model.Jugador;
import com.example.parcial2.Service.JugadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jugador")
@RequiredArgsConstructor
public class JugadorController {
    private final JugadorService jugadorService;

    @GetMapping("/listar")
    public ResponseEntity<List<Jugador>> listar(){
        List<Jugador> jugadores = jugadorService.listar();
        return ResponseEntity.ok(jugadores);
    }

    @GetMapping("/buscar/{id_jugador}")
    public ResponseEntity<Object> buscar(@PathVariable Long id_jugador){
        Optional<Jugador> jugador = jugadorService.buscar(id_jugador);
        if(jugador.isPresent()){
            return ResponseEntity.ok(jugador.get());
        } else {
            return ResponseEntity.status(404)
                    .body("No se encontró el jugador con ID: " + id_jugador);
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody Jugador jugador){
        try {
            jugadorService.guardar(jugador);
            return ResponseEntity.ok("Jugador guardado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al guardar el jugador: " + e.getMessage());
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody Jugador jugador){
        try {
            jugadorService.actualizar(jugador);
            return ResponseEntity.ok("Jugador actualizado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar el jugador: " + e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id_jugador}")
    public ResponseEntity<?> eliminar(@PathVariable Long id_jugador){
        try {
            jugadorService.eliminar(id_jugador);
            return ResponseEntity.ok("Jugador eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al eliminar el jugador: " + e.getMessage());
        }
    }
}
