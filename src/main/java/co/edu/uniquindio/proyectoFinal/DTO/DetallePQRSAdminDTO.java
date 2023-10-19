package co.edu.uniquindio.proyectoFinal.DTO;

import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Cita;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.EstadoPQRS;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DetallePQRSAdminDTO(
        @NotNull
        String nombrePaciente,
        @NotNull
        String cedulaPaciente,
        @NotNull
        Cita cita,
        @NotNull
        EstadoPQRS estadoPQRS,
        List<RespuestaPQRSDTO> mensajes
) {
}
