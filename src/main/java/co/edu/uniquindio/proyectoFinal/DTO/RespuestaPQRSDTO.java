package co.edu.uniquindio.proyectoFinal.DTO;

import java.time.LocalDateTime;

public record RespuestaPQRSDTO(
    int codigoMensaje,
    String mensaje,
    String nombreUsuario,
    LocalDateTime fecha
) {
}
