package co.edu.uniquindio.proyectoFinal.DTO;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record RespuestaPQRSDTO(
    @NotNull
    int codigoMensaje,
    @NotNull
    String mensaje,
    @NotNull
    String nombreUsuario,
    @NotNull
    LocalDateTime fecha
) {
}
