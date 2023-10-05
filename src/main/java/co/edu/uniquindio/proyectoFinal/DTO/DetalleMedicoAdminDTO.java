package co.edu.uniquindio.proyectoFinal.DTO;

import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.Ciudad;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.Especialidad;

import java.util.List;

public record DetalleMedicoAdminDTO(
        String nombre,
        String cedula,
        Ciudad ciudad,
        Especialidad especialidad,
        String telefono,
        String correo,
        String urlFoto,
        List<HorarioDTO> horarioDTO
) {

}
