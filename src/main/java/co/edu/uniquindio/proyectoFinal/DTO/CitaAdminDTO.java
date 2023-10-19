package co.edu.uniquindio.proyectoFinal.DTO;

import java.time.LocalDateTime;

public record CitaAdminDTO(
        String medico,
        LocalDateTime fechaAtencion,
        String paciente
) {
}
