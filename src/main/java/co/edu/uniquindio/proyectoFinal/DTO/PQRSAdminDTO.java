package co.edu.uniquindio.proyectoFinal.DTO;

import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Cita;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.EstadoPQRS;

public record PQRSAdminDTO(
        String nombrePaciente,
        String cedulaPaciente,
        String motivoConsulta,
        EstadoPQRS estado
) {
}
