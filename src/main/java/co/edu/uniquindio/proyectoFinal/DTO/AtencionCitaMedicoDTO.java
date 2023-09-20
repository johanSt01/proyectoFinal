package co.edu.uniquindio.proyectoFinal.DTO;

public record AtencionCitaMedicoDTO(
        String nombre,
        String cedula,
        String telefono,
        String tiposangre,
        String fechaNacimiento,
        String EPS,
        String alergias,
        String ciudadResidencia,
        String notas
) {
}
