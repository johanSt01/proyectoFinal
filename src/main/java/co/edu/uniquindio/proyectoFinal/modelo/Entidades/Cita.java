package co.edu.uniquindio.proyectoFinal.modelo.Entidades;

import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.EstadoCita;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cita implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(updatable = true, nullable = false)
    private Date fechaCreacion;

    @Column(updatable = true, nullable = false)
    private LocalDate fechaCita;

    @Column(updatable = true, nullable = false)
    private LocalTime horaCita;

    @Column(updatable = true, nullable = false)
    private String motivo;

    @OneToMany(mappedBy = "codigo_cita")
    private List<PQRS> pqrs;

    @ManyToOne
    private Paciente cedulaPaciente;

    @ManyToOne
    private Medico codigoMedico;

    private EstadoCita codigoEstado;

    @OneToOne (mappedBy = "codigo_cita")
    private Atencion atencion;
}
