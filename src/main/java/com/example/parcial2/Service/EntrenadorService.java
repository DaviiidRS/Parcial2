package com.example.parcial2.Service;

import com.example.parcial2.Model.Entrenador;
import com.example.parcial2.Repository.EntrenadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EntrenadorService {
    private final EntrenadorRepository entrenadorRepository;

    public List<Entrenador> listar(){
        return entrenadorRepository.findAll();
    }

    public Optional <Entrenador> buscar(Long id){
        return entrenadorRepository.findById(id);
    }

    public Entrenador guardar(Entrenador entrenador){
        return entrenadorRepository.save(entrenador);
    }

    public Entrenador actualizar(Entrenador entrenador){
        if (entrenador.getId_entrenador() == null || !entrenadorRepository.existsById(entrenador.getId_entrenador())) {
            throw new IllegalArgumentException("El entrenador no encontrado");
        }
        return entrenadorRepository.save(entrenador);
    }

    public boolean eliminar(Long id){
        if (entrenadorRepository.existsById(id)) {
            entrenadorRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
