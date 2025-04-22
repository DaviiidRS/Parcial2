package com.example.parcial2.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_entrenador;
    private String nombre;
    private String especialidad;

    @ManyToOne
    @JoinColumn(name="id_equipo")
    private Equipo equipo;
}
