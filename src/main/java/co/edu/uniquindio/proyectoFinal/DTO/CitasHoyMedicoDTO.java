package co.edu.uniquindio.proyectoFinal.DTO;

import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

public record CitasHoyMedicoDTO(
        @NotNull
        LocalTime hora,
        @NotNull
        String nombre
) {
}
