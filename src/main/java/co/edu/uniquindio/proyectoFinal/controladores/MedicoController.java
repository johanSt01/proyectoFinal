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
    public List<CitaMedicoDTO> listarCitasPendientes()throws Exception {
        return medicoServicio.listarCitasPendientes();
    }

    @PutMapping("/atenderCita")
    public int atenderCita(@Valid @RequestBody AtencionCitaMedicoDTO atencionCitaMedicoDTO) throws Exception{
        return medicoServicio.atenderCita(atencionCitaMedicoDTO);
    }

    @GetMapping("/listarHistorialCitas")
    public List<HistorialCitasMedicoDTO> listarHistorialCitas()throws Exception {
        return medicoServicio.listarHistorialCitas();
    }

    @PostMapping("/agendarDiaLibre/{diaSeleccionado, codigoMedico}")
    public DiaLibre agendarDiaLibre(@PathVariable LocalDate diaSeleccionado, int codigoMedico) throws Exception{
        return medicoServicio.agendarDiaLibre(diaSeleccionado, codigoMedico);
    }

    @GetMapping("/listarCitasRealizadas")
    public List<CitasHoyMedicoDTO> listarCitasRealizadas()throws Exception {
        return medicoServicio.listarCitasRealizadas();
    }

    @PutMapping("/posponerCita")
    public void posponerCita(@Valid @RequestBody PosponerCitaMedicoDTO posponerCitaMedicoDTO) throws Exception{
        medicoServicio.posponerCita(posponerCitaMedicoDTO);
    }

}
