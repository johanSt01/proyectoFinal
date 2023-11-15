package co.edu.uniquindio.proyectoFinal;

import co.edu.uniquindio.proyectoFinal.DTO.EmailDTO;
import co.edu.uniquindio.proyectoFinal.servicios.Interfaces.EmailServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class EmailServicioTest {

    @Autowired
    private EmailServicio emailServicio;

    @Test
    public void enviarEmailTest(){

        EmailDTO emailDTO = new EmailDTO(
                "Test de verificacion",
                "Este es un correo de verificación de uso de email en la aplicación",
                "correo"
        );
        try {
            emailServicio.enviarEmail(emailDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
