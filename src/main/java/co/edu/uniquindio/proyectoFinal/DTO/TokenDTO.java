package co.edu.uniquindio.proyectoFinal.DTO;

import jakarta.validation.constraints.NotBlank;

public record TokenDTO(
        @NotBlank
        String Token
) {
}
