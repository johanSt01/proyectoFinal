package co.edu.uniquindio.proyectoFinal.DTO;

import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Cita;
import jakarta.validation.constraints.NotNull;

public record PQRSPacienteDTO(
        @NotNull
        Cita citaAsociada,
        @NotNull
        String tipoPQRS,
        @NotNull
        String detalle
) {
}
