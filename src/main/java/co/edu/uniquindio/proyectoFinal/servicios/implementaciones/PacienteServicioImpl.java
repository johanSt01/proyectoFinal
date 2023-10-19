package co.edu.uniquindio.proyectoFinal.servicios.implementaciones;

import co.edu.uniquindio.proyectoFinal.DTO.*;
import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Cita;
import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Paciente;
import co.edu.uniquindio.proyectoFinal.repositorios.CitaRepository;
import co.edu.uniquindio.proyectoFinal.servicios.Interfaces.PacienteServicio;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteServicioImpl implements PacienteServicio {

    private final CitaRepository citaRepo;

    @Override
    public String registrarse(RegistroUsuarioDTO registroUsuarioDTO) throws Exception {
        return null;
    }

    @Override
    public String editarPerfil(Paciente paciente) {
        return null;
    }

    @Override
    public String eliminarCuenta(String codigoCuenta) throws Exception {
        return null;
    }

    @Override
    public String enviarLinkRecuperacion(EnviarCorreoPacienteDTO correoPacienteDTO) throws Exception {
        return null;
    }

    @Override
    public String cambiarPassword(ContraseniaPacienteDTO contraseniaPaciente) throws Exception {
        return null;
    }

    @Override
    public String agendarCita(AgendarCitaPacienteDTO agendarCita) throws Exception {
        if(citaRepo.findByCodigoMedicoCodigoAndFechaCitaAndHoraCita(agendarCita.medico().getCodigo(), agendarCita.fecha(), agendarCita.hora())==null){
            System.out.println("cita: "+citaRepo.findByCodigoMedicoCodigoAndFechaCitaAndHoraCita(agendarCita.medico().getCodigo(), agendarCita.fecha(), agendarCita.hora()));
            throw new Exception("ya existe una cita para esa fecha y con ese medico");

        }

        Cita cita = datosCita(agendarCita);
        Cita citaNueva = citaRepo.save(cita);
        return "cita creada"+citaNueva.getCodigo();
    }

    public static Cita datosCita(AgendarCitaPacienteDTO agendarCitaPacienteDTO){
        Cita cita = new Cita();
        cita.setEspecialidad(agendarCitaPacienteDTO.especialidad());
        cita.setCodigoMedico(agendarCitaPacienteDTO.medico());
        cita.setFechaCita(agendarCitaPacienteDTO.fecha());
        cita.setHoraCita(agendarCitaPacienteDTO.hora());
        cita.setMotivo(agendarCitaPacienteDTO.motivoCita());
        return cita;
    }

    @Override
    public void crearPQRS(PQRSPacienteDTO pqrsPacienteDTO) throws Exception {

    }

    @Override
    public List<HistorialPQRSPacienteDTO> listarPQRSPaciente() {
        return null;
    }

    @Override
    public void responderPQRS(String mensaje) {

    }

    @Override
    public List<CitasPacienteDTO> listarCitasPaciente() {
        return null;
    }

    @Override
    public Cita filtrarCitasPorFecha(String fechaCita) throws Exception {
        return null;
    }

    @Override
    public Cita filtrarCitasPorMedico(String nombreMedico) throws Exception {
        return null;
    }

    @Override
    public Cita verDetalleCita(int codigoCita) throws Exception {
        return null;
    }
}
