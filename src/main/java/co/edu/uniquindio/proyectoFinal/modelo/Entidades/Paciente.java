package co.edu.uniquindio.proyectoFinal.modelo.Entidades;

import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.EPS;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.TipoSangre;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Paciente extends Usuario implements Serializable  {

    @Column(updatable = true, nullable = false)
    private LocalDate fechaNacimiento;

    @Column(nullable = true, insertable = true, updatable = true)
    private String alergias;

    @OneToMany(mappedBy = "cedulaPaciente")
    private List<Cita> cita;

    private EPS codigo_eps;

    private TipoSangre codigo_tipo_sangre;
}
