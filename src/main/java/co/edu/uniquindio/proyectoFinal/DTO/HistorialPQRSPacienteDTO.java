package co.edu.uniquindio.proyectoFinal.DTO;

import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.EstadoPQRS;
import jakarta.validation.constraints.NotNull;

public record HistorialPQRSPacienteDTO(
        @NotNull
        String numRadicado,
        @NotNull
        String fechaCreacion,
        @NotNull
        String citaAsociada,
        @NotNull
        EstadoPQRS estado,
        @NotNull
        String respuesta
) {
}
