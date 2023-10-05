package co.edu.uniquindio.proyectoFinal.Repositorios;

import co.edu.uniquindio.proyectoFinal.modelo.Entidades.PQRS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PQRSRepository extends JpaRepository<PQRS, Integer> {

}
