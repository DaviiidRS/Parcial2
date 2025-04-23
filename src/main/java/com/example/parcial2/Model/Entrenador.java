package com.example.parcial2.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @JoinColumn(name="id_equipo")
    private Equipo equipo;

    @Transient
    private Long id_equipo;

}
