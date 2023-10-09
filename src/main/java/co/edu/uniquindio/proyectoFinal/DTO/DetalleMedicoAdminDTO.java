package co.edu.uniquindio.proyectoFinal.DTO;

import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.Ciudad;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.Especialidad;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DetalleMedicoAdminDTO(
        @NotNull
        int codigo,
        @NotNull
        String nombre,
        @NotNull
        String cedula,
        @NotNull
        Ciudad ciudad,
        @NotNull
        Especialidad especialidad,
        @NotNull
        String telefono,
        @NotNull
        String correo,
        @NotNull
        String urlFoto,
        @NotNull
        List<HorarioDTO> horarioDTO
) {

}
