package co.edu.uniquindio.proyectoFinal.DTO;

import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.Especialidad;
import jakarta.validation.constraints.NotNull;

public record InforMedicoAdminDTO (
    @NotNull
    String nombre,
    @NotNull
    String cedula,
    @NotNull
    String telefono,
    @NotNull
    Especialidad especialidad){
}
