package co.edu.uniquindio.proyectoFinal.DTO;

public record CitasPacienteDTO(
        String fechaCreacion,
        String fechaCita,
        String hora,
        String medico,
        String estado,
        String motivoCita
) {
}
