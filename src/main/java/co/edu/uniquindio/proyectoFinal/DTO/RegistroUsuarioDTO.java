package co.edu.uniquindio.proyectoFinal.DTO;

public record RegistroUsuarioDTO(
        String nombre,
        String cedula,
        String fechaNacimiento,
        String telefono,
        String ciudad,
        String tipoSangre,
        String EPS,
        String alergias,
        String email,
        String contrasenia,
        String urlFoto
) {
}
