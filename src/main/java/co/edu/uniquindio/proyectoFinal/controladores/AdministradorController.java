package co.edu.uniquindio.proyectoFinal.controladores;

import co.edu.uniquindio.proyectoFinal.DTO.*;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.EstadoPQRS;
import co.edu.uniquindio.proyectoFinal.servicios.Interfaces.AdministradorServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/administradores")
@AllArgsConstructor
public class AdministradorController {

    private final AdministradorServicio administradorServicio;

    @GetMapping("/crearMedico")
    public ResponseEntity<MensajeDTO<String>> CrearMedico(@Valid @RequestBody MedicoDTO medicoDTO) throws Exception{
        administradorServicio.crearMedico(medicoDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "El medico ha sido creado correctamente" ));
    }

    @PostMapping("/actualizarMedico")
    public ResponseEntity<MensajeDTO<String>> ActualizarMedico(@Valid @RequestBody DetalleMedicoAdminDTO detalleMedicoAdminDTO) throws Exception {
        administradorServicio.actualizarMedico(detalleMedicoAdminDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "La información del medico ha sido actualizada correctamente" ));
    }

    @DeleteMapping("/eliminarMedico")
    public ResponseEntity<MensajeDTO<String>> EliminarMedico(@PathVariable int codigoMedico) throws Exception {
        administradorServicio.eliminarMedico(codigoMedico);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "El medico ha sido eliminado correctamente" ));
    }

    @GetMapping("/listarMedicos")
    public ResponseEntity<MensajeDTO<List<InforMedicoAdminDTO>>> ListarMedicos() throws Exception {
        return ResponseEntity.ok().body( new MensajeDTO<>(false, administradorServicio.listarMedico()));
    }

    @GetMapping("/obtenerMedico")
    public ResponseEntity<MensajeDTO<DetalleMedicoAdminDTO>> oObtenerMedico(int codigoMedico) throws Exception {
        return ResponseEntity.ok().body( new MensajeDTO<>(false, administradorServicio.obtenerMedico(codigoMedico)));
    }

    @GetMapping("/listarPQRS")
    public ResponseEntity<MensajeDTO<List<PQRSAdminDTO>>> ListarPQRS() throws Exception {
        return ResponseEntity.ok().body( new MensajeDTO<>(false, administradorServicio.listarPQRS()));
    }

    @PostMapping("/responderPQRS")
    public ResponseEntity<MensajeDTO<String>> ResponderPQRS(@Valid @RequestBody RegistroRespuestaPQRSDTO registroRespuestaPQRSDTO) throws Exception{
        administradorServicio.responderPQRS(registroRespuestaPQRSDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "La respuesta del pqrs ha sido registrado" ));
    }

    @GetMapping("/detallePQRS")
    public ResponseEntity<MensajeDTO<DetallePQRSAdminDTO>> VerDetallePQRS(int codigoPQRS) throws Exception {
        return ResponseEntity.ok().body( new MensajeDTO<>(false, administradorServicio.verDetallePQRS(codigoPQRS)));
    }

    @PostMapping("/cambiarEstadoPQRS")
    public ResponseEntity<MensajeDTO<String>> CambiarEstadoPQRS(@PathVariable int codigoPQRS, EstadoPQRS estadoPQRS) throws Exception {
        administradorServicio.cambiarEstadoPQRS(codigoPQRS, estadoPQRS);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "El estado de la pqrs ha sido cambiados correctamente" ));
    }

    @GetMapping("/listarCitas")
    public ResponseEntity<MensajeDTO<List<CitaAdminDTO>>> ListarCitas() throws Exception {
        return ResponseEntity.ok().body( new MensajeDTO<>(false, administradorServicio.listarCitas()));
    }
}
