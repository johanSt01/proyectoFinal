package co.edu.uniquindio.proyectoFinal;

import co.edu.uniquindio.proyectoFinal.DTO.LoginDTO;
import co.edu.uniquindio.proyectoFinal.DTO.PosponerCitaMedicoDTO;
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
            medicoServicio.agendarDiaLibre(LocalDate.of(2023, 11, 29), 2);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void posponerCitaTest(){
        LocalDate fecha = LocalDate.of(2024, 1,1);
        LocalTime hora= LocalTime.of(12,0,0);
        try {
            PosponerCitaMedicoDTO posponerCitaMedicoDTO = new PosponerCitaMedicoDTO(
                    1,
                    fecha,
                    hora
            );
            medicoServicio.posponerCita(posponerCitaMedicoDTO);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void listarCitas(){
        try{
            medicoServicio.listarHistorialCitas();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void citasPendientes(){
        try{
            medicoServicio.listarCitasPendientes();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void citasrealizadas(){
        try{
            medicoServicio.listarCitasRealizadas();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
