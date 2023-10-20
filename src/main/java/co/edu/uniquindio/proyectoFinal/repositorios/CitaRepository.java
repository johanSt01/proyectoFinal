package co.edu.uniquindio.proyectoFinal.repositorios;

import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Cita;
import co.edu.uniquindio.proyectoFinal.modelo.Entidades.PQRS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository <Cita, Integer> {
    Cita findByCodigo(int codigo);

    List<Cita> findByCodigoMedicoCodigoAndFechaCita(int codigoMedico, LocalDate fecha);

    List<Cita> findByCodigoMedicoCodigoAndFechaCitaAndHoraCita(int codigoMedico, LocalDate fecha, LocalTime hora);

    List<Cita> findByFechaCita(LocalDate codigoCita);

    List<Cita> findByCodigoMedicoCodigo(int codigoMedico);

    List<Cita> findByCedulaPacienteCodigo(int codigoPaciente);

}
