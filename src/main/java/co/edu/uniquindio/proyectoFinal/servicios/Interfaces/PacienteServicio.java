package co.edu.uniquindio.proyectoFinal.servicios.Interfaces;

import co.edu.uniquindio.proyectoFinal.DTO.*;
import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Cita;
import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Paciente;

import java.util.List;

public interface PacienteServicio {
    String registrarse(RegistroUsuarioDTO registroUsuarioDTO)throws Exception;

    String editarPerfil(Paciente paciente);

    String eliminarCuenta(String codigoCuenta)throws Exception;

    String enviarLinkRecuperacion(EnviarCorreoPacienteDTO correoPacienteDTO)throws Exception;

    String cambiarPassword(ContraseniaPacienteDTO contraseniaPaciente)throws Exception;

    String agendarCita(AgendarCitaPacienteDTO agendarCitaPacienteDTO)throws Exception;

    void crearPQRS(PQRSPacienteDTO pqrsPacienteDTO)throws Exception;

    List<HistorialPQRSPacienteDTO> listarPQRSPaciente();

    void responderPQRS(String mensaje);

    List<CitasPacienteDTO> listarCitasPaciente();

    Cita filtrarCitasPorFecha(String fechaCita)throws Exception;

    Cita filtrarCitasPorMedico(String nombreMedico)throws Exception;

    Cita verDetalleCita(int codigoCita)throws Exception;
}
