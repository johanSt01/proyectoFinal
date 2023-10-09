package co.edu.uniquindio.proyectoFinal.DTO;

import jakarta.validation.constraints.NotNull;

public record EnviarCorreoPacienteDTO (
        @NotNull String correo
){
}
