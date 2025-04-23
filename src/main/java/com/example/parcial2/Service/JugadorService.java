package com.example.parcial2.Service;

import com.example.parcial2.Model.Jugador;
import com.example.parcial2.Repository.JugadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JugadorService {
    private final JugadorRepository jugadorrepository;

    public List<Jugador> listar() {
        return jugadorrepository.findAll();
    }

    public Optional<Jugador> buscar(Long id_jugador){
        return jugadorrepository.findById(id_jugador);
    }

    public Jugador guardar(Jugador jugador) {
        return jugadorrepository.save(jugador);
    }

    public Jugador actualizar(Jugador jugador) {
        if (jugador.getId_jugador() == null || !jugadorrepository.existsById(jugador.getId_jugador())) {
            throw new IllegalArgumentException("Jugador no encontrado");
        }
        return jugadorrepository.save(jugador);
    }

    public boolean eliminar(Long id_jugador) {
        if (jugadorrepository.existsById(id_jugador)) {
            jugadorrepository.deleteById(id_jugador);
            return true;
        } else {
            return false;
        }
    }
}
