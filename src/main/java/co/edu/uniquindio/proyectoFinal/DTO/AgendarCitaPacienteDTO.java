package co.edu.uniquindio.proyectoFinal.DTO;

import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Medico;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.Especialidad;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record AgendarCitaPacienteDTO(
        @NotNull
        Especialidad especialidad,
        @NotNull
        Medico medico,
        @NotNull
        LocalDate fecha,
        @NotNull
        LocalTime hora,
        @NotNull
        String motivoCita
) {
}
