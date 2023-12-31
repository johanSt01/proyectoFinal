package co.edu.uniquindio.proyectoFinal.DTO;

import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Paciente;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record CitaMedicoDTO(
        @NotNull
        LocalDate fecha,
        @NotNull
        LocalTime hora,
        @NotNull
        String nombrePaciente
) {
}
