package co.edu.uniquindio.proyectoFinal.DTO;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record HistorialCitasMedicoDTO(
        @NotNull
        LocalDate fecha,
        @NotNull
        LocalTime hora,
        @NotNull
        String nombrePaciente,
        @NotNull
        String diagnostico
) {
}
