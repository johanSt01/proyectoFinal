package co.edu.uniquindio.proyectoFinal;

import co.edu.uniquindio.proyectoFinal.DTO.LoginDTO;
import co.edu.uniquindio.proyectoFinal.DTO.TokenDTO;
import co.edu.uniquindio.proyectoFinal.servicios.Interfaces.AutenticacionServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AutenticacionTest {

    @Autowired
    private AutenticacionServicio autenticacionServicio;

    @Test
    public void loginTest(){
        try {
            TokenDTO token = autenticacionServicio.login(new LoginDTO(
                    "123jak@email.com",
                    "1"
                    ));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
