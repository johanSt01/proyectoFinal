package co.edu.uniquindio.proyectoFinal.servicios.Interfaces;

import co.edu.uniquindio.proyectoFinal.DTO.EmailDTO;

public interface EmailServicio {

    void enviarEmail(EmailDTO emailDTO) throws Exception;
}
