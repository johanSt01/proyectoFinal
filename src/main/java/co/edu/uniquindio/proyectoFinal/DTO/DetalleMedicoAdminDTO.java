package co.edu.uniquindio.proyectoFinal.DTO;

import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.Ciudad;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.Especialidad;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

import java.time.LocalTime;

public record DetalleMedicoAdminDTO(
        @Positive
        int codigo,
        @NotEmpty
        @Length(max = 200)
        String nombre,
        @Length(max = 12)
        String cedula,
        @NotNull
        Ciudad ciudad,
        @NotNull
        Especialidad especialidad,
        @NotNull
        LocalTime horaInicio,
        @NotNull
        LocalTime horaFin,
        @Length(max = 10)
        String telefono,
        @NotEmpty
        @Email
        @Length (max = 80)
        String correo,
        @NotEmpty
        String urlFoto
) {
}
