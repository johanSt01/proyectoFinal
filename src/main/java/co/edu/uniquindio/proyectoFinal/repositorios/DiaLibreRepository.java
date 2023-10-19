package co.edu.uniquindio.proyectoFinal.repositorios;

import co.edu.uniquindio.proyectoFinal.modelo.Entidades.DiaLibre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface DiaLibreRepository extends JpaRepository<DiaLibre, Integer> {

    DiaLibre findByCodigoMedicoCodigoAndDia(int codigoMedico, LocalDate dia);
}
