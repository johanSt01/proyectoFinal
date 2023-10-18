package co.edu.uniquindio.proyectoFinal.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record RespuestaPQRSDTO(
        @Positive
        int codigoPQRS,
        @Positive
        int codigoUsuario,
        @NotBlank
        String mensaje
) {
}
