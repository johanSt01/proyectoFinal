package co.edu.uniquindio.proyectoFinal.controladores;

import co.edu.uniquindio.proyectoFinal.DTO.LoginDTO;
import co.edu.uniquindio.proyectoFinal.DTO.MensajeDTO;
import co.edu.uniquindio.proyectoFinal.DTO.RegistroUsuarioDTO;
import co.edu.uniquindio.proyectoFinal.DTO.TokenDTO;
import co.edu.uniquindio.proyectoFinal.servicios.Interfaces.AdministradorServicio;
import co.edu.uniquindio.proyectoFinal.servicios.Interfaces.AutenticacionServicio;
import co.edu.uniquindio.proyectoFinal.servicios.implementaciones.PacienteServicioImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AutenticacionController {

    private final AutenticacionServicio autenticacionServicio;
    private final PacienteServicioImpl pacienteServicio;


    @PostMapping("/login")
    public ResponseEntity<MensajeDTO<TokenDTO>> login(@Valid @RequestBody LoginDTO loginDTO)
            throws Exception {
        TokenDTO tokenDTO = autenticacionServicio.login(loginDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, tokenDTO));
    }

    @PostMapping("/registrarse")
    public ResponseEntity<MensajeDTO<String>> registrarse(@Valid @RequestBody RegistroUsuarioDTO registroUsuarioDTO)
            throws Exception {
        pacienteServicio.registrarse(registroUsuarioDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Paciente registrado correctamente"));
    }
}
