package com.example.parcial2.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_equipo;

    private String nombre;
    private String ciudad;
    private LocalDate fundacion;

    @OneToMany(mappedBy = "equipo")
    @JsonIgnore
    private List<Jugador> jugadores;

    @OneToMany(mappedBy = "equipo")
    @JsonIgnore
    private List<Entrenador> entrenadores;

    @OneToMany(mappedBy = "equipo_local")
    @JsonIgnore
    private List<Partido> partidos_locales;

    @OneToMany(mappedBy = "equipo_visita")
    @JsonIgnore
    private List<Partido> partidos_visitantes;


}
