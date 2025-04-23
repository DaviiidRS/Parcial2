package com.example.parcial2.Controller;

import com.example.parcial2.Model.EstadisticasJugador;
import com.example.parcial2.Service.EstadisticasJugadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estadisticas")
@RequiredArgsConstructor
public class EstadisticasJugadorController {
    private final EstadisticasJugadorService estadisticasJugadorService;

    @GetMapping("/listar")
    public ResponseEntity<List<EstadisticasJugador>> listar(){
        List<EstadisticasJugador> estadisticasJugadores = estadisticasJugadorService.listar();
        return ResponseEntity.ok(estadisticasJugadores);
    }
    @GetMapping("/listar/{id_jugador}")
    public ResponseEntity<Object> buscar(@PathVariable Long id_jugador){
        Optional<EstadisticasJugador> estadisticasJugador = estadisticasJugadorService.buscar(id_jugador);
        if(estadisticasJugador.isPresent()){
            return ResponseEntity.ok(estadisticasJugador.get());
        } else {
            return ResponseEntity.status(404)
                    .body("No se encontró el jugador con ID: " + id_jugador);
        }
    }
    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody EstadisticasJugador estadisticasJugador){
        try {
            estadisticasJugadorService.guardar(estadisticasJugador);
            return ResponseEntity.ok("Estadísticas del jugador guardadas correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al guardar las estadísticas del jugador: " + e.getMessage());
        }
    }
    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody EstadisticasJugador estadisticasJugador){
        try {
            estadisticasJugadorService.actualizar(estadisticasJugador);
            return ResponseEntity.ok("Estadísticas del jugador actualizadas correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar las estadísticas del jugador: " + e.getMessage());
        }
    }
    @DeleteMapping("/eliminar/{id_jugador}")
    public ResponseEntity<?> eliminar(@PathVariable Long id_jugador){
        try {
            estadisticasJugadorService.eliminar(id_jugador);
            return ResponseEntity.ok("Estadísticas del jugador eliminadas correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al eliminar las estadísticas del jugador: " + e.getMessage());
        }
    }
}
