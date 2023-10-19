package co.edu.uniquindio.proyectoFinal.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public record PosponerCitaDTO(
        int codigoCita,
        LocalDate fechaEsperada,
        LocalTime horaEsperada
) {
}
