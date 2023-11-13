package co.edu.uniquindio.proyectoFinal;

import co.edu.uniquindio.proyectoFinal.DTO.LoginDTO;
import co.edu.uniquindio.proyectoFinal.DTO.TokenDTO;
import co.edu.uniquindio.proyectoFinal.servicios.Interfaces.AutenticacionServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Transactional
public class AutenticacionTest {

    @Autowired
    private AutenticacionServicio autenticacionServicio;

    @Test
    @Sql("classpath:dataset.sql")
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
