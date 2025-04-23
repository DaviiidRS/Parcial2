package com.example.parcial2.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_partido;
    private LocalDate fecha;
    private String estadio;
    // llaves foráneas
    @ManyToOne
    @JoinColumn(name="id_equipo_local")
    @JsonIgnore
    private Equipo equipo_local;

    @ManyToOne
    @JoinColumn(name="id_equipo_visita")
    @JsonIgnore
    private Equipo equipo_visita;

    private Long goles_local;
    private Long goles_visita;

    @OneToMany(mappedBy = "partido")
    @JsonIgnore
    private List<EstadisticasJugador> estadisticasJugadores;

}
