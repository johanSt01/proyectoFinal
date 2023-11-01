package co.edu.uniquindio.proyectoFinal.DTO;

import lombok.AllArgsConstructor;


public record ValidacionDTO(
        String campo,
        String error
) {
}
