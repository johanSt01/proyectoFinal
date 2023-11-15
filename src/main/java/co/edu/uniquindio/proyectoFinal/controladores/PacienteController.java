package co.edu.uniquindio.proyectoFinal.controladores;

import co.edu.uniquindio.proyectoFinal.DTO.*;
import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Cita;
import co.edu.uniquindio.proyectoFinal.servicios.Interfaces.PacienteServicio;
import co.edu.uniquindio.proyectoFinal.servicios.implementaciones.PacienteServicioImpl;
import jakarta.validation.Valid;
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

    @PostMapping("/registrarse")
    public ResponseEntity<MensajeDTO<String>> Registrarse(@Valid @RequestBody RegistroUsuarioDTO registroUsuarioDTO) throws Exception {
        pacienteServicio.registrarse(registroUsuarioDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Paciente registrado correctamente"));
    }

    @PutMapping("/editarPerfil")
    public ResponseEntity<MensajeDTO<String>> EditarPerfil(@Valid @RequestBody DetallePacienteDTO detallePacienteDTO) throws Exception {
        pacienteServicio.editarPerfil(detallePacienteDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "el perfil se ha editado correctamente"));
    }

    @DeleteMapping("/eliminarPerfil/{codigoCuenta}")
    public ResponseEntity<MensajeDTO<String>> eliminarPerfil(@PathVariable int codigoCuenta) throws Exception{
        pacienteServicio.eliminarCuenta(codigoCuenta);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "El perfil ha sido eliminado correctamente"));
    }

    @PutMapping("/enviarLinkRecuperacion")
    public ResponseEntity<MensajeDTO<String>> EnviarLinkRecuperacion(@Valid @RequestBody EnviarCorreoPacienteDTO enviarCorreoPacienteDTO) throws Exception {
        pacienteServicio.enviarLinkRecuperacion(enviarCorreoPacienteDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "el correo ha sido enviado correctamente"));
    }

    @PutMapping("/cambiarPassword")
    public ResponseEntity<MensajeDTO<String>> CambiarPassword(@Valid @RequestBody ContraseniaPacienteDTO contraseniaPacienteDTO) throws Exception {
        pacienteServicio.cambiarPassword(contraseniaPacienteDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "la contraseña ha sido cambiada correctamente"));
    }

    @PostMapping("/agendarCita")
    public ResponseEntity<MensajeDTO<String>> AgendarCita(@Valid @RequestBody AgendarCitaPacienteDTO agendarCitaPacienteDTO) throws Exception {
        pacienteServicio.agendarCita(agendarCitaPacienteDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "la cita ha sido agendada correctamente"));
    }

    @PostMapping("/crearPQRS")
    public ResponseEntity<MensajeDTO<String>> CrearPQRS (@Valid @RequestBody PQRSPacienteDTO pqrsPacienteDTO) throws Exception {
        pacienteServicio.crearPQRS(pqrsPacienteDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "la pqrs ha sido creada correctamente"));
    }

    @GetMapping("/listarPQRS")
    public ResponseEntity<MensajeDTO<List<HistorialPQRSPacienteDTO>>> ListarPQRS() throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteServicio.listarPQRSPaciente()));
    }

    @PostMapping("/responderPQRS/{mensaje}")
    public ResponseEntity<MensajeDTO<String>> ResponderPQRS (@PathVariable String mensaje) throws Exception {
        pacienteServicio.responderPQRS(mensaje);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "la pqrs ha sido respondida correctamente"));
    }

    @GetMapping("/listarCitas/{codigoPaciente}")
    public ResponseEntity<MensajeDTO<List<CitasPacienteDTO>>> listarCitasPaciente (@PathVariable int codigoPaciente) throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteServicio.listarCitasPaciente(codigoPaciente)));
    }

    @GetMapping("/listarCitasPorFecha/{fecha}")
    public ResponseEntity<MensajeDTO<List<Cita>>> ListarCitasPorFecha (@PathVariable LocalDate fecha) throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteServicio.filtrarCitasPorFecha(fecha)));
    }

    @GetMapping("/listarCitasPorMedico/{codigoMedico}")
    public ResponseEntity<MensajeDTO<List<Cita>>> ListarCitasPorMedico (@PathVariable int codigoMedico) throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteServicio.filtrarCitasPorMedico(codigoMedico)));
    }

    @GetMapping("/verDetalleCita/{codigoCita}")
    public ResponseEntity<MensajeDTO<DetalleCitaPacienteDTO>> VerDetalleCita (@PathVariable int codigoCita) throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteServicio.verDetalleCita(codigoCita)));
    }

    @PutMapping("/posponerCita/{codigoCita}/{fecha}/{hora}")
    public ResponseEntity<MensajeDTO<String>> PosponerCita (@PathVariable int codigoCita, @PathVariable LocalDate fecha, @PathVariable LocalTime hora) throws Exception {
        pacienteServicio.posponerCita(codigoCita, fecha, hora);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "La cita ha cambiado de fecha y hora correctamente"));
    }
}
