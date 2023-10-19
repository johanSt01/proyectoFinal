package co.edu.uniquindio.proyectoFinal.DTO;

import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Cita;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.EstadoPQRS;
import java.util.List;

public record DetallerPQRSAdminDTO(
        String nombrePaciente,
        String cedulaPaciente,
        Cita cita,
        EstadoPQRS estado
        List<RespuestaPQRSDTO> mensajes
) {
}
