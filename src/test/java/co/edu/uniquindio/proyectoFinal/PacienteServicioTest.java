package co.edu.uniquindio.proyectoFinal;

import co.edu.uniquindio.proyectoFinal.DTO.AgendarCitaPacienteDTO;
import co.edu.uniquindio.proyectoFinal.DTO.RegistroUsuarioDTO;
import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Medico;
import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Paciente;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.Ciudad;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.EPS;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.Especialidad;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.TipoSangre;
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

    @Test
    public void RegistrarPaciente(){
        LocalDate fechaNacimiento = LocalDate.of(2000,2,15);
        RegistroUsuarioDTO usuarioDTO = new RegistroUsuarioDTO(
                "juan",
                "123456",
                fechaNacimiento,
                "326578",
                Ciudad.Pereira,
                TipoSangre.ABpositivos,
                EPS.NuevaEPS,
                "no",
                "juan@uqvirtual.edu.co",
                "123456",
                "URL"
        );
        try{
            pacienteServicio.registrarse(usuarioDTO);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void eliminrPaciente(){
        try {
            pacienteServicio.eliminarCuenta(18);
        }catch (Exception e){
            System.out.println("Error: "+ e.getMessage());
        }
    }

    @Test
    public void listarcitasFecha(){
        try{
            LocalDate fecha = LocalDate.of(2023,10,19);
            pacienteServicio.filtrarCitasPorFecha(fecha);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void listarCitasMedico(){
        try {
            pacienteServicio.filtrarCitasPorMedico(2);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void detalleCita(){
        try{
            pacienteServicio.verDetalleCita(1);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
