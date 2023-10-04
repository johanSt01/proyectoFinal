package co.edu.uniquindio.proyectoFinal.DTO;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record MedicoDTO (

        @NotNull
         String cedula,
        @NotNull
         String nombreCompleto,
        @NotNull
        @Length(max = 10) //se le tiene que hacer a todos los campos que esten limitados en la base de datos
         String telefono,
        @NotNull
         int ciudad,
        @NotNull
         int especialidad,
        @NotNull
         String correo,
        @NotNull
         String contrasenia,
        @NotNull
         List<HorarioDTO> horarioDTO
){
}
