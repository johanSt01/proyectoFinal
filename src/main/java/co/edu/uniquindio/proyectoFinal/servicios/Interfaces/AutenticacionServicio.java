package co.edu.uniquindio.proyectoFinal.servicios.Interfaces;

import co.edu.uniquindio.proyectoFinal.DTO.LoginDTO;
import co.edu.uniquindio.proyectoFinal.DTO.TokenDTO;

public interface AutenticacionServicio {
    TokenDTO login(LoginDTO loginDTO) throws Exception;
}
