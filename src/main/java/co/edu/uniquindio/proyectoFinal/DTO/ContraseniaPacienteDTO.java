package co.edu.uniquindio.proyectoFinal.DTO;

import jakarta.validation.constraints.NotNull;

public record ContraseniaPacienteDTO(
        @NotNull String contrasenia
) {
}
