package co.edu.uniquindio.proyectoFinal.DTO;

import jakarta.validation.constraints.NotNull;

public record AgendarCitaPacienteDTO(
        @NotNull
        String especialidad,
        @NotNull
        String medico,
        @NotNull
        String fecha,
        @NotNull
        String hora,
        @NotNull
        String motivoCita
) {
}
