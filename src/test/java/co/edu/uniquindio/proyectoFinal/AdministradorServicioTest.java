package co.edu.uniquindio.proyectoFinal;

import co.edu.uniquindio.proyectoFinal.DTO.DetalleMedicoAdminDTO;
import co.edu.uniquindio.proyectoFinal.DTO.HorarioDTO;
import co.edu.uniquindio.proyectoFinal.DTO.MedicoDTO;
import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Cita;
import co.edu.uniquindio.proyectoFinal.modelo.Entidades.DiaLibre;
import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Horario;
import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Medico;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.Ciudad;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.Especialidad;
import co.edu.uniquindio.proyectoFinal.servicios.Interfaces.AdministradorServicio;
import co.edu.uniquindio.proyectoFinal.servicios.Interfaces.MedicoServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class AdministradorServicioTest {

    @Autowired
    private AdministradorServicio administradorServicio;

    @Test
    public void crearMedicoTest(){

        List<HorarioDTO> horarios = new ArrayList<>();
        horarios.add( new HorarioDTO("7:00", "12:00") );

        try {
            administradorServicio.crearMedico( new MedicoDTO(
                    "1272",
                    "juan",
                    "762762",
                    Ciudad.Armenia,
                    Especialidad.Odontologia,
                    "pepito@email.com",
                    "8778hjd",
                    "url",
                    horarios
            ));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void actualizarMedico(){
        List<HorarioDTO> horarios = new ArrayList<>();
        horarios.add( new HorarioDTO("7:00", "12:00") );
        try{
            administradorServicio.actualizarMedico(new DetalleMedicoAdminDTO(
                    4,
                    "juan",
                    "762762",
                    Ciudad.Cali,
                    Especialidad.Dermatologia,
                    "123654",
                    "pepito@email.com",
                    "url",
                    horarios

            ));
        }catch(Exception e){
            System.out.println("problemas");
        }
    }

    @Test
    public void eliminarMedicoTest(){
        try{
            administradorServicio.eliminarMedico(1);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
