package com.example.parcial2.Controller;

import com.example.parcial2.Model.Entrenador;
import com.example.parcial2.Service.EntrenadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/entrenador")
@RequiredArgsConstructor
public class EntrenadorController {
    private final EntrenadorService entrenadorService;

    public ResponseEntity<List<Entrenador>> listar(){
        List<Entrenador> entrenadores = entrenadorService.listar();
        return ResponseEntity.ok(entrenadores);
    }
    public ResponseEntity<Entrenador> buscar(Long id){
        return entrenadorService.buscar(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    public ResponseEntity<Entrenador> guardar(Entrenador entrenador){
        Entrenador nuevoEntrenador = entrenadorService.guardar(entrenador);
        return ResponseEntity.ok(nuevoEntrenador);
    }
    public ResponseEntity<Entrenador> actualizar(Entrenador entrenador){
        Entrenador actualizado = entrenadorService.actualizar(entrenador);
        return ResponseEntity.ok(actualizado);
    }
    public ResponseEntity<Void> eliminar(Long id){
        if (entrenadorService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
