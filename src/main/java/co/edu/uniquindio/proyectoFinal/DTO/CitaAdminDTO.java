package co.edu.uniquindio.proyectoFinal.DTO;

import java.time.LocalDate;

public record CitaAdminDTO(
        String medico,
        LocalDate fechaAtencion,
        String paciente
) {
}
