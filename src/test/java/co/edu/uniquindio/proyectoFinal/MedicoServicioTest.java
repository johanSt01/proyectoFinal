package co.edu.uniquindio.proyectoFinal;

import co.edu.uniquindio.proyectoFinal.DTO.LoginDTO;
import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Medico;
import co.edu.uniquindio.proyectoFinal.servicios.Interfaces.MedicoServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootTest
public class MedicoServicioTest {

    @Autowired
    private MedicoServicio medicoServicio;

    @Test
    public void diaDescansoMedico(){
        try {
            medicoServicio.agendarDiaLibre(LocalDate.of(2023, 10, 29), 1);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void posponerCitaTest(){
        try {
            medicoServicio.posponerCita(1, LocalDate.of(2023, 10, 29), LocalTime.of(14, 30, 0));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void login(){
        try{
            medicoServicio.iniciarSesion(new LoginDTO(
                    "pepito@email.com",
                    "8778hjd"
            ));
        }catch(Exception e){
            System.out.println("problemas");
        }
    }
}
