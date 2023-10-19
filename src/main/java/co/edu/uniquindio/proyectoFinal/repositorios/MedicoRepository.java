package co.edu.uniquindio.proyectoFinal.repositorios;

import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository <Medico, Integer> {

    Medico findByCorreo(String correo);

    Medico findByCorreoAndContrasenia(String corre, String contrasenia);

    Medico findByCedula(String cedula);
}
