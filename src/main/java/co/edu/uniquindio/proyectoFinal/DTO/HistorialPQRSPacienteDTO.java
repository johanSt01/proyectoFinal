package co.edu.uniquindio.proyectoFinal.DTO;

import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.EstadoPQRS;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record HistorialPQRSPacienteDTO(
        @NotNull
        int numRadicado,
        @NotNull
        LocalDate fechaCreacion,
        @NotNull
        int citaAsociada,
        @NotNull
        EstadoPQRS estado
) {
}
