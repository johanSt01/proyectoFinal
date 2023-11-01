package co.edu.uniquindio.proyectoFinal.controladores;

import co.edu.uniquindio.proyectoFinal.DTO.*;
import co.edu.uniquindio.proyectoFinal.modelo.Entidades.DiaLibre;
import co.edu.uniquindio.proyectoFinal.servicios.Interfaces.MedicoServicio;
import co.edu.uniquindio.proyectoFinal.servicios.Interfaces.PacienteServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/medicos")
@AllArgsConstructor
public class MedicoController {

    private final MedicoServicio medicoServicio;

    @GetMapping("/listarCitasPendientes")
    public ResponseEntity<MensajeDTO<List<CitaMedicoDTO>>> listarCitasPendientes()throws Exception {
        return ResponseEntity.ok().body( new MensajeDTO<>(false, medicoServicio.listarCitasPendientes()) );
    }

    @PutMapping("/atenderCita")
    public ResponseEntity<MensajeDTO<String>> atenderCita(@Valid @RequestBody AtencionCitaMedicoDTO atencionCitaMedicoDTO) throws Exception{
        medicoServicio.atenderCita(atencionCitaMedicoDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "La cita ha sido atendida correctamente" ));
    }

    @GetMapping("/listarHistorialCitas")
    public ResponseEntity<MensajeDTO<List<HistorialCitasMedicoDTO>>> listarHistorialCitas() throws Exception {
        return ResponseEntity.ok().body( new MensajeDTO<>(false, medicoServicio.listarHistorialCitas()));
    }

    @PostMapping("/agendarDiaLibre/{diaSeleccionado, codigoMedico}")
    public ResponseEntity<MensajeDTO<String>> agendarDiaLibre(@PathVariable LocalDate diaSeleccionado, int codigoMedico) throws Exception{
        medicoServicio.agendarDiaLibre(diaSeleccionado, codigoMedico);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "El dia libre ha sido agendado correctamente" ));
    }

    @GetMapping("/listarCitasHoy")
    public ResponseEntity<MensajeDTO<List<CitasHoyMedicoDTO>>> listarCitasRealizadas()throws Exception {
        return ResponseEntity.ok().body( new MensajeDTO<>(false, medicoServicio.listarCitasHoy()));
    }

    @PostMapping("/posponerCita")
    public ResponseEntity<MensajeDTO<String>> posponerCita(@Valid @RequestBody PosponerCitaMedicoDTO posponerCitaMedicoDTO) throws Exception{
        medicoServicio.posponerCita(posponerCitaMedicoDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "La fecha de la cita ha sido cambiada correctamente" ));
    }

}
