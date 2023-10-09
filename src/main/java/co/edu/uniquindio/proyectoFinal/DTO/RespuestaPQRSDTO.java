package co.edu.uniquindio.proyectoFinal.DTO;

import jakarta.validation.constraints.NotNull;

public record RespuestaPQRSDTO(
        @NotNull int codigoPQRS,
        @NotNull
        int codigoUsuario,
        @NotNull
        String mensaje
) {
}
