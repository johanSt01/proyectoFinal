package co.edu.uniquindio.proyectoFinal.DTO;

import jakarta.validation.constraints.NotNull;

public record AtencionCitaMedicoDTO(
        @NotNull
        String nombre,
        @NotNull
        String cedula,
        @NotNull
        String telefono,
        @NotNull
        String tiposangre,
        @NotNull
        String fechaNacimiento,
        @NotNull
        String EPS,
        @NotNull
        String alergias,
        @NotNull
        String ciudadResidencia,
        @NotNull
        String notas
) {
}
