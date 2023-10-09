package co.edu.uniquindio.proyectoFinal.DTO;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DiaLibreMedicoDTO(
        @NotNull
        LocalDate fecha,
        @NotNull
        String paciente
) {
}
