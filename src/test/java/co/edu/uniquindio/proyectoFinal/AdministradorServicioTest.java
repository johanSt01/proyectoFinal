package co.edu.uniquindio.proyectoFinal;

import co.edu.uniquindio.proyectoFinal.DTO.*;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.Ciudad;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.Especialidad;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.EstadoPQRS;
import co.edu.uniquindio.proyectoFinal.servicios.Interfaces.AdministradorServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalTime;
import java.util.List;

@SpringBootTest
public class AdministradorServicioTest {

    @Autowired
    private AdministradorServicio administradorServicio;

    @Test
    public void crearMedicoTest(){

        MedicoDTO medicoDTO = new MedicoDTO(
                "389134",
                "Lorena",
                "76352145",
                Ciudad.Cali,
                Especialidad.Dermatologia,
                LocalTime.of(7,0,0),
                LocalTime.of(17,0,0),
                "Lore@email.com",
                "803jfiu9",
                "url"
        );
        try {
            administradorServicio.crearMedico(medicoDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void actualizarMedicoTest(){
        try {
            DetalleMedicoAdminDTO medicoDTO = administradorServicio.obtenerMedico(1);

            DetalleMedicoAdminDTO medicoDTONuevo = new DetalleMedicoAdminDTO(
                    1,
                    medicoDTO.nombre(),
                    medicoDTO.cedula(),
                    Ciudad.Pereira,
                    medicoDTO.especialidad(),
                    medicoDTO.horaInicio(),
                    medicoDTO.horaFin(),
                    "72782",
                    medicoDTO.correo(),
                    medicoDTO.urlFoto()
            );

            administradorServicio.actualizarMedico(medicoDTONuevo);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void eliminarMedicoTest(){
        try {
            administradorServicio.eliminarMedico(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void listarMedicoTest(){
        try {
            List<InforMedicoAdminDTO> lista = administradorServicio.listarMedico();
            lista.forEach( System.out::println);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void listarPQRSTest(){
        try {
            List<PQRSAdminDTO> lista = administradorServicio.listarPQRS();
            lista.forEach( System.out::println);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void responderPQRSTest(){
        try {

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Test
    public void DetallePQRSAdminDTOTest(){
        try {
            DetallePQRSAdminDTO detallePQRSAdminDTO = administradorServicio.verDetallePQRS(1);

            DetallePQRSAdminDTO detallePQRSAdminDTONuevo = new DetallePQRSAdminDTO(
                    detallePQRSAdminDTO.nombrePaciente(),
                    detallePQRSAdminDTO.cedulaPaciente(),
                    detallePQRSAdminDTO.cita(),
                    detallePQRSAdminDTO.estado(),
                    detallePQRSAdminDTO.mensajes()
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void cambiarEstadoPQRSTest(){
        try {
            administradorServicio.cambiarEstadoPQRS(1, EstadoPQRS.terminado);
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }

    @Test
    public void listarCitasTest(){
        try {
            List<CitaAdminDTO> lista = administradorServicio.listarCitas();
            lista.forEach( System.out::println);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
