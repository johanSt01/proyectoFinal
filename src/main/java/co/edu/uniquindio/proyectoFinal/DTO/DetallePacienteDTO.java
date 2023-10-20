package co.edu.uniquindio.proyectoFinal.DTO;

import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.Ciudad;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.EPS;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.TipoSangre;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DetallePacienteDTO(

        @NotNull
        int codigo,
        @NotNull
        String nombre,
        @NotNull
        String cedula,
        @NotNull
        LocalDate fechaNacimiento,
        @NotNull
        String telefono,
        @NotNull
        Ciudad ciudad,
        @NotNull
        TipoSangre tipoSangre,
        @NotNull
        EPS eps,
        @NotNull
        String alergias,
        @NotNull
        String email
) {
}
