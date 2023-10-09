package co.edu.uniquindio.proyectoFinal.DTO;

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
        String estado,
        @NotNull
        String motivoCita
) {
}
