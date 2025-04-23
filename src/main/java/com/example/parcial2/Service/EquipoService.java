package com.example.parcial2.Service;

import com.example.parcial2.Model.Equipo;
import com.example.parcial2.Repository.EquipoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EquipoService {
    private final EquipoRepository equipoRepository;

    public List<Equipo> listar(){
        return equipoRepository.findAll();
    }

    public Optional<Equipo> buscar(Long id_equipo){
        return equipoRepository.findById(id_equipo);
    }

    public Equipo guardar(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public Equipo actualizar(Equipo equipo){
        if (equipo.getId_equipo() == null || !equipoRepository.existsById(equipo.getId_equipo())) {
            throw new IllegalArgumentException("Equipo no encontrado");
        }
        return equipoRepository.save(equipo);
    }
    public boolean eliminar(Long id_equipo){
        if (equipoRepository.existsById(id_equipo)) {
            equipoRepository.deleteById(id_equipo);
            return true;
        } else {
            return false;
        }
    }
}
