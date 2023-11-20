package co.edu.uniquindio.proyectoFinal.DTO;

import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.Especialidad;

public record MedicoEspecialidadDTO(
        int codigo,
        String nombre,
        Especialidad especialidad
) {
}
