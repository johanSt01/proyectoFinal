package co.edu.uniquindio.proyectoFinal.controladores;

import co.edu.uniquindio.proyectoFinal.DTO.MensajeDTO;
import co.edu.uniquindio.proyectoFinal.servicios.Interfaces.ClinicaServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/clinica")

public class ClinicaController {

    private final ClinicaServicio clinicaServicio;

    @GetMapping("/lista-ciudades")
    public ResponseEntity<MensajeDTO> ListarCiudades()throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false, clinicaServicio.listarCiudades()));
    }
    @GetMapping("/lista-eps")
    public ResponseEntity<MensajeDTO> listarEPS()throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false, clinicaServicio.listarEPS()));
    }

    @GetMapping("/lista-tipo-sangre")
    public ResponseEntity<MensajeDTO> listarTipoSangre()throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false, clinicaServicio.listarTipoSangre()));
    }

    @GetMapping("/lista-especialidades")
    public ResponseEntity<MensajeDTO> listarEspecialidades()throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false, clinicaServicio.listarEspecialidades()));
    }

}
