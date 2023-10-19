package co.edu.uniquindio.proyectoFinal.DTO;

import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.Ciudad;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.Especialidad;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalTime;
import java.util.List;

public record MedicoDTO (

        @NotNull
        String cedula,
        @NotNull
        String nombre,
        @NotNull
        @Length(max = 10) //se le tiene que hacer a todos los campos que esten limitados en la base de datos
        String telefono,
        @NotNull
        Ciudad ciudad,
        @NotNull
        Especialidad especialidad,
        @NotNull
        LocalTime horaInicio,
        @NotNull
        LocalTime horaFin,
        @NotNull
        String correo,
        @NotNull
        String contrasenia,
        @NotNull
        String URLfoto
){
}
