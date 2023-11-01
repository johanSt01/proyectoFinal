package co.edu.uniquindio.proyectoFinal.controladores;

import co.edu.uniquindio.proyectoFinal.DTO.*;
import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Cita;
import co.edu.uniquindio.proyectoFinal.servicios.Interfaces.PacienteServicio;
import co.edu.uniquindio.proyectoFinal.servicios.implementaciones.PacienteServicioImpl;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/pacienteController")
public class PacienteController {

    private final PacienteServicioImpl pacienteServicio;

    @PutMapping("/registrarse")
    public ResponseEntity<MensajeDTO<String>> Registrarse(RegistroUsuarioDTO registroUsuarioDTO) throws Exception {
        pacienteServicio.registrarse(registroUsuarioDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "El usuario se ha paciente correctamente"));
    }

    @PostMapping("/editarPerfil")
    public ResponseEntity<MensajeDTO<String>> EditarPerfil(DetallePacienteDTO detallePacienteDTO) throws Exception {
        pacienteServicio.editarPerfil(detallePacienteDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "el perfil se ha editado correctamente"));
    }

    @DeleteMapping
    public ResponseEntity<MensajeDTO<String>> eliminarPerfil(int codigoCuenta) throws Exception{
        pacienteServicio.eliminarCuenta(codigoCuenta);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "El perfil ha sido eliminado correctamente"));
    }

    @PostMapping("/enviarLinkRecuperacion")
    public ResponseEntity<MensajeDTO<String>> EnviarLinkRecuperacion(EnviarCorreoPacienteDTO enviarCorreoPacienteDTO) throws Exception {
        pacienteServicio.enviarLinkRecuperacion(enviarCorreoPacienteDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "el correo ha sido enviado correctamente"));
    }

    @PostMapping("/cambiarPassword")
    public ResponseEntity<MensajeDTO<String>> CambiarPassword(ContraseniaPacienteDTO contraseniaPacienteDTO) throws Exception {
        pacienteServicio.cambiarPassword(contraseniaPacienteDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "la contraseña ha sido cambiada correctamente"));
    }

    @PutMapping("/agendarCita")
    public ResponseEntity<MensajeDTO<String>> AgendarCita(AgendarCitaPacienteDTO agendarCitaPacienteDTO) throws Exception {
        pacienteServicio.agendarCita(agendarCitaPacienteDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "la cita ha sido agendada correctamente"));
    }

    @PutMapping("/crearPQRS")
    public ResponseEntity<MensajeDTO<String>> CrearPQRS (PQRSPacienteDTO pqrsPacienteDTO) throws Exception {
        pacienteServicio.crearPQRS(pqrsPacienteDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "la pqrs ha sido creada correctamente"));
    }

    @GetMapping("/listarPQRS")
    public ResponseEntity<MensajeDTO<List<HistorialPQRSPacienteDTO>>> ListarPQRS() throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteServicio.listarPQRSPaciente()));
    }

    @PostMapping("/responderPQRS")
    public ResponseEntity<MensajeDTO<String>> ResponderPQRS (String mensaje) throws Exception {
        pacienteServicio.responderPQRS(mensaje);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "la pqrs ha sido respondida correctamente"));
    }

    @GetMapping("/listarCitas")
    public ResponseEntity<MensajeDTO<List<CitasPacienteDTO>>> listarCitasPaciente (int codigoPaciente) throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteServicio.listarCitasPaciente(codigoPaciente)));
    }

    @GetMapping("/listarCitasPorFecha")
    public ResponseEntity<MensajeDTO<List<Cita>>> ListarCitasPorFecha (LocalDate fecha) throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteServicio.filtrarCitasPorFecha(fecha)));
    }

    @GetMapping("/listarCitasPorMedico")
    public ResponseEntity<MensajeDTO<List<Cita>>> ListarCitasPorMedico (int codigoMedico) throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteServicio.filtrarCitasPorMedico(codigoMedico)));
    }

    @GetMapping("/verDetalleCita")
    public ResponseEntity<MensajeDTO<DetalleCitaPacienteDTO>> VerDetalleCita (int codigoCita) throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteServicio.verDetalleCita(codigoCita)));
    }

    @PostMapping("/posponerCita")
    public ResponseEntity<MensajeDTO<String>> PosponerCita (int codigoCita, LocalDate fecha, LocalTime hora) throws Exception {
        pacienteServicio.posponerCita(codigoCita, fecha, hora);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "La cita ha cambiado de fecha y hora correctamente"));
    }
}
