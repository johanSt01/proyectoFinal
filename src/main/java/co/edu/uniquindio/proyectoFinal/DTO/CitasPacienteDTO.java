package co.edu.uniquindio.proyectoFinal.DTO;

import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.EstadoCita;
import jakarta.validation.constraints.NotNull;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public record CitasPacienteDTO(
        @NotNull
        LocalDate fechaCreacion,
        @NotNull
        LocalDate fechaCita,
        @NotNull
        LocalTime hora,
        @NotNull
        String medico,
        @NotNull
        EstadoCita estado,
        @NotNull
        String motivoCita
) {
}
