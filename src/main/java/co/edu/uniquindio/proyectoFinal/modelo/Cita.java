package co.edu.uniquindio.proyectoFinal.modelo;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
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
    private Date fechaCreacion;
    private Date fechaCita;
    private String motivo;

    @OneToMany(mappedBy = "codigo_cita")
    private List<PQRS> pqrs;

    @ManyToOne
    private Paciente cedula_paciente;

    private EstadoCita codigo_estado;

    @OneToOne (mappedBy = "codigo_cita")
    private Atencion atencion;
}
