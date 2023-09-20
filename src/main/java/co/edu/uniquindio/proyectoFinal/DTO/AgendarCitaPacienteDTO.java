package co.edu.uniquindio.proyectoFinal.DTO;

public record AgendarCitaPacienteDTO(
        String especialidad,
        String medico,
        String fecha,
        String hora,
        String motivoCita
) {
}
