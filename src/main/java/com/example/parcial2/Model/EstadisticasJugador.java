package com.example.parcial2.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstadisticasJugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_estadistica;

    @ManyToOne
    @JoinColumn(name="id_jugador")
    private Jugador jugador;

    @ManyToOne
    @JoinColumn(name="id_partido")
    private Partido partido;

    private Long minutos_jugados;
    private Long goles;
    private Long asistencias;
    private Long tarjetas_amarillas;
    private Long tarjetas_rojas;
}
