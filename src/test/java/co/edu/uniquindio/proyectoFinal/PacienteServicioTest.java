package co.edu.uniquindio.proyectoFinal;

import co.edu.uniquindio.proyectoFinal.DTO.AgendarCitaPacienteDTO;
import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Medico;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.Especialidad;
import co.edu.uniquindio.proyectoFinal.servicios.Interfaces.PacienteServicio;
import com.sun.jdi.event.ExceptionEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootTest
public class PacienteServicioTest {

    @Autowired
    private PacienteServicio pacienteServicio;

//    @Test
//    public void crearCita(){
//        Medico medico = new Medico();
//        LocalDate fecha = LocalDate.of(2023, 12, 15);
//        LocalTime hora= LocalTime.of(12, 30);
//        String motivo="urgencia";
//
//        try{
//            pacienteServicio.agendarCita(new AgendarCitaPacienteDTO(Especialidad.Odontologia,
//                    medico,
//                    fecha,
//                    hora,
//                    motivo
//            ));
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//    }
}
