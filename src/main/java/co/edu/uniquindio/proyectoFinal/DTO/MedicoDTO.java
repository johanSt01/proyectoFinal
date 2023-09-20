package co.edu.uniquindio.proyectoFinal.DTO;

import java.util.List;

public record MedicoDTO (
         String cedula,
         String nombreCompleto,
         String telefono,
         String ciudad,
         String especialidad,
         String correo,
         String contrasenia,
         List<HorarioDTO> horarioDTO
){
}
