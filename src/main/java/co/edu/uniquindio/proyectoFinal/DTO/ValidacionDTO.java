package co.edu.uniquindio.proyectoFinal.DTO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public record ValidacionDTO(
        String campo,
        String error
) {
}
