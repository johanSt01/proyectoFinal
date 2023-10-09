package co.edu.uniquindio.proyectoFinal.DTO;

import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

public record HorarioDTO (
        @NotNull
        LocalTime horaLlegada,
        @NotNull
        LocalTime horaSalida
) {

}
