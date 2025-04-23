package com.example.parcial2.Service;

import com.example.parcial2.Model.Partido;
import com.example.parcial2.Repository.PartidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartidoService {
    private final PartidoRepository partidoRepository;

    public List<Partido> listar() {
        return partidoRepository.findAll();
    }
    public Partido buscar(Long id_partido) {
        return partidoRepository.findById(id_partido)
                .orElseThrow(() -> new RuntimeException("Partido no encontrado"));
    }
    public Partido guardar(Partido partido) {
        return partidoRepository.save(partido);
    }
    public Partido actualizar(Partido partido) {
        if (partido.getId_partido() == null || !partidoRepository.existsById(partido.getId_partido())) {
            throw new IllegalArgumentException("Partido no encontrado");
        }
        return partidoRepository.save(partido);
    }
    public boolean eliminar(Long id_partido) {
        if (partidoRepository.existsById(id_partido)) {
            partidoRepository.deleteById(id_partido);
            return true;
        } else {
            return false;
        }
    }

}
