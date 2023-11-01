package co.edu.uniquindio.proyectoFinal.DTO;


public record MensajeDTO<T>(
        boolean error,
        T respuesta
) {
}
