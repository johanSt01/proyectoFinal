package co.edu.uniquindio.proyectoFinal.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public record PosponerCitaMedicoDTO(
        int codigoCita,
        LocalDate fechaPropuesta,
        LocalTime horaPropuesta
) {
}
