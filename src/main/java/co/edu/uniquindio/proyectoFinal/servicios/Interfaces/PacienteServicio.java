package co.edu.uniquindio.proyectoFinal.servicios.Interfaces;

import co.edu.uniquindio.proyectoFinal.DTO.*;
import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Cita;
import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Paciente;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.Especialidad;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface PacienteServicio {
    int registrarse(RegistroUsuarioDTO registroUsuarioDTO)throws Exception;

    int editarPerfil(DetallePacienteDTO paciente)throws Exception;

    DetallePacienteDTO detallePaciente(int codigo)throws Exception;

    void eliminarCuenta(int codigoCuenta)throws Exception;

    String enviarLinkRecuperacion(EnviarCorreoPacienteDTO correoPacienteDTO)throws Exception;

    String cambiarPassword(ContraseniaPacienteDTO contraseniaPaciente)throws Exception;

    String agendarCita(AgendarCitaPacienteDTO agendarCitaPacienteDTO)throws Exception;

    int crearPQRS(PQRSPacienteDTO pqrsPacienteDTO)throws Exception;

    List<HistorialPQRSPacienteDTO> listarPQRSPaciente() throws Exception;

    void responderPQRS(String mensaje);

    List<CitasPacienteDTO> listarCitasPaciente(int codigoPaciente) throws Exception;

    List<Cita> filtrarCitasPorFecha(LocalDate fechaCita)throws Exception;

    List<Cita> filtrarCitasPorMedico(int codigoMedico)throws Exception;

    DetalleCitaPacienteDTO verDetalleCita(int codigoCita)throws Exception;

    void posponerCita(int codigoCita, LocalDate fecha, LocalTime hora) throws Exception;
    List<MedicoEspecialidadDTO> obtenerMedicosEspecialidad(Especialidad especialidad) throws Exception;

}
