package co.edu.uniquindio.proyectoFinal.repositorios;

import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta,Integer> {
    Optional<Cuenta> findByCorreo(String correo);
}
