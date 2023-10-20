package co.edu.uniquindio.proyectoFinal.servicios.implementaciones;

import co.edu.uniquindio.proyectoFinal.DTO.LoginDTO;
import co.edu.uniquindio.proyectoFinal.DTO.TokenDTO;
import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Cuenta;
import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Medico;
import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Paciente;
import co.edu.uniquindio.proyectoFinal.repositorios.CuentaRepository;
import co.edu.uniquindio.proyectoFinal.servicios.Interfaces.AutenticacionServicio;
import co.edu.uniquindio.proyectoFinal.utils.JWTUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AutenticacionServicioImp implements AutenticacionServicio {

    private final CuentaRepository cuentaRepo;
    private final JWTUtils jwtUtils;

    @Override
    public TokenDTO login(LoginDTO loginDTO) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Optional<Cuenta> cuentaOptional = cuentaRepo.findByCorreo(loginDTO.correo());

        if(cuentaOptional.isEmpty()){
            throw new Exception("No existe el correo ingresado");
        }
        Cuenta cuenta = cuentaOptional.get();
        if( !passwordEncoder.matches(loginDTO.contrasenia(), cuenta.getContrasenia()) ){
            throw new Exception("La contraseña ingresada es incorrecta");
        }
        return new TokenDTO( crearToken(cuenta) );
    }

    private String crearToken(Cuenta cuenta) {
        String rol;
        String nombre;
        if( cuenta instanceof Paciente){
            rol = "paciente";
            nombre = ((Paciente) cuenta).getNombre();
        }else if( cuenta instanceof Medico){
            rol = "medico";
            nombre = ((Medico) cuenta).getNombre();
        }else{
            rol = "admin";
            nombre = "Administrador";
        }
        Map<String, Object> map = new HashMap<>();
        map.put("rol", rol);
        map.put("nombre", nombre);
        map.put("id", cuenta.getCodigo());
        return jwtUtils.generarToken(cuenta.getCorreo(), map);
    }
}
