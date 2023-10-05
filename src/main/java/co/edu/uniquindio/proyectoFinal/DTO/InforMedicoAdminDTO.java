package co.edu.uniquindio.proyectoFinal.DTO;

import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.Especialidad;

public record InforMedicoAdminDTO (
    String nombre,
    String cedula,
    String telefono,
    Especialidad especialidad){
}
