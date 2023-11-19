package co.edu.uniquindio.proyectoFinal;

import co.edu.uniquindio.proyectoFinal.DTO.AgendarCitaPacienteDTO;
import co.edu.uniquindio.proyectoFinal.DTO.PQRSPacienteDTO;
import co.edu.uniquindio.proyectoFinal.DTO.RegistroUsuarioDTO;
import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Cita;
import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Medico;
import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Paciente;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.Ciudad;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.EPS;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.Especialidad;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.TipoSangre;
import co.edu.uniquindio.proyectoFinal.servicios.Interfaces.PacienteServicio;
import com.sun.jdi.event.ExceptionEvent;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@SpringBootTest
@Transactional
public class PacienteServicioTest {

    @Autowired
    private PacienteServicio pacienteServicio;


    @Test
    public void crearPQRS(){
        Cita cita = null;
        PQRSPacienteDTO nuevoPQRS = new PQRSPacienteDTO(
                cita,
                "",
                ""
        );
        try{
            pacienteServicio.crearPQRS(nuevoPQRS);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void RegistrarPaciente(){
        LocalDate fechaNacimiento = LocalDate.of(2001,2,15);
        RegistroUsuarioDTO usuarioDTO = new RegistroUsuarioDTO(
                "juanmanuel",
                "12345678",
                fechaNacimiento,
                "3265568",
                Ciudad.Pereira,
                TipoSangre.ABpositivos,
                EPS.NuevaEPS,
                "no",
                "juanma@uqvirtual.edu.co",
                "12344456",
                "URL"
        );
        try{
            pacienteServicio.registrarse(usuarioDTO);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminrPaciente(){
        try {
            pacienteServicio.eliminarCuenta(16);
        }catch (Exception e){
            System.out.println("Error: "+ e.getMessage());
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarcitasFecha(){
        try{
            LocalDate fecha = LocalDate.of(2023,10,19);
            pacienteServicio.filtrarCitasPorFecha(fecha);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCitasMedico(){
        try {
            pacienteServicio.filtrarCitasPorMedico(2);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void detalleCita(){
        try{
            pacienteServicio.verDetalleCita(1);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
