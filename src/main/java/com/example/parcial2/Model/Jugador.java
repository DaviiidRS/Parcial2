package com.example.parcial2.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_jugador;
    private String nombre;
    private String pocision;
    private Long dorsal;
    private LocalDate fecha_nac;
    private String nacionalidad;

    @ManyToOne
    @JoinColumn(name="id_equipo")
    private Equipo equipo;
}
