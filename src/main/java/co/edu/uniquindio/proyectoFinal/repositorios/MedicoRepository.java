package co.edu.uniquindio.proyectoFinal.repositorios;

import co.edu.uniquindio.proyectoFinal.DTO.MedicoEspecialidadDTO;
import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Medico;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepository extends JpaRepository <Medico, Integer> {

    Medico findByCorreo(String correo);

    Medico findByCorreoAndContrasenia(String corre, String contrasenia);

    Medico findByCedula(String cedula);
    List<MedicoEspecialidadDTO> findMedicoByEspecialidad(Especialidad especialidad);
}
