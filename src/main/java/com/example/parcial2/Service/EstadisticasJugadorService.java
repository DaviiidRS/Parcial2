package com.example.parcial2.Service;

import com.example.parcial2.Model.EstadisticasJugador;
import com.example.parcial2.Repository.EstadisticasJugadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstadisticasJugadorService {
    private final EstadisticasJugadorRepository estadisticasJugadorRepository;

    public List<EstadisticasJugador> listar() {
        return estadisticasJugadorRepository.findAll();
    }

    public Optional<EstadisticasJugador> buscar (Long id_estadistica){
        return estadisticasJugadorRepository.findById(id_estadistica);
    }
    public EstadisticasJugador guardar(EstadisticasJugador estadisticasJugador) {
        return estadisticasJugadorRepository.save(estadisticasJugador);
    }
    public EstadisticasJugador actualizar (EstadisticasJugador estadisticasJugador){
        if (estadisticasJugador.getId_estadistica() == null || !estadisticasJugadorRepository.existsById(estadisticasJugador.getId_estadistica())) {
            throw new IllegalArgumentException("Estadisticas no encontradas");
        }
        return estadisticasJugadorRepository.save(estadisticasJugador);
    }
    public boolean eliminar(Long id_estadistica) {
        if (estadisticasJugadorRepository.existsById(id_estadistica)) {
            estadisticasJugadorRepository.deleteById(id_estadistica);
            return true;
        } else {
            return false;
        }
    }
}
