package co.edu.uniquindio.proyectoFinal.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public record DetalleCitaPacienteDTO(

        LocalDate fechaCita,
        LocalTime horaCita,
        String nombreMedico,
        String nombrePaciente
) {
}
