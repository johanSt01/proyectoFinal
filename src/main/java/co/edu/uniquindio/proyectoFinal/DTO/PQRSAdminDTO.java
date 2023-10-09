package co.edu.uniquindio.proyectoFinal.DTO;

import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Cita;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.EstadoPQRS;
import jakarta.validation.constraints.NotNull;

public record PQRSAdminDTO(
        @NotNull
        String nombrePaciente,
        @NotNull
        String cedulaPaciente,
        @NotNull
        Cita cita,
        @NotNull
        EstadoPQRS estado
) {
}
